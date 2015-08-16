package br.edu.ftlf.ads.revenda.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.conversation.Compra;
import br.edu.ftlf.ads.revenda.dao.AquisicoesDao;
import br.edu.ftlf.ads.revenda.dao.ClientesDao;
import br.edu.ftlf.ads.revenda.dao.FormasPagamentosDao;
import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.dao.VeiculosDao;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Enums.SituacaoAquisicao;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.view.ClienteModelView;
import br.edu.ftlf.ads.revenda.view.CompraModelView;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

@Controller
public class AquisicoesController {

	private final Result result;
	private final Validator validator;
	
	private final AquisicoesDao aquisicoesDao;
	private final FuncionariosDao funcionariosDao;
	private final ClientesDao clientesDao;
	private final VeiculosDao veiculosDao;
	private final FormasPagamentosDao formasPagamentosDao;
	
	private final Compra compra;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected AquisicoesController() {
		this(null, null, null, null, null, null, null, null);
	}
	
	@Inject
	public AquisicoesController(Result result, Validator validator, 
								AquisicoesDao aquisicoesService, 
								FuncionariosDao funcionariosService, 
								ClientesDao clientesService, 
								VeiculosDao veiculosService, 
								FormasPagamentosDao formasPagamentosService,
								Compra aquisicaoConversation) {
		this.result = result;
		this.validator = validator;
		this.aquisicoesDao = aquisicoesService;
		this.funcionariosDao = funcionariosService;
		this.clientesDao = clientesService;
		this.veiculosDao = veiculosService;
		this.formasPagamentosDao = formasPagamentosService;
		this.compra = aquisicaoConversation;
	}
	
	@Get("aquisicao/veiculo")
	public void veiculo() {
		compra.beginConversation();		
		result.include("veiculos", veiculosDao.list());
		result.include("combustiveis", Combustivel.values());
	}
		
	@IncludeParameters
	@Path(priority=Path.HIGHEST, value = { "aquisicao/veiculo" })
	@Post
	public void veiculo(VeiculoModelView veiculo) {
		compra.registerConversation();
		compra.setVeiculo(veiculo);
		validator.validate(veiculo);
		if (validator.hasErrors()) {
			result.include("veiculos", veiculosDao.list());
			result.include("combustiveis", Combustivel.values());
			validator.onErrorUsePageOf(this).veiculo();
		}
		
		result.include("clientes", clientesDao.list());
		result.include("vendedores", funcionariosDao.getVendedores());
		result.of(this).cliente();
	}
	
	@Get("aquisicao/cliente")
	public void cliente() {
		compra.registerConversation();
		result.include("clientes", clientesDao.list());
		result.include("vendedores", funcionariosDao.getVendedores());
	}
	
	@IncludeParameters
	@Path(priority=Path.HIGHEST, value = { "aquisicao/cliente" })
	@Post
	public void cliente(ClienteModelView cliente) {
		compra.registerConversation();
		validator.validate(cliente);
		if (validator.hasErrors()) {
			result.include("clientes", clientesDao.list());
			result.include("vendedores", funcionariosDao.getVendedores());
			validator.onErrorUsePageOf(this).cliente();
		}
		compra.setCliente(cliente);
		result.of(this).compra();
	}
	
	@Get("aquisicao/compra")
	public void compra() {	
		compra.registerConversation();
	}
	
	@IncludeParameters
	@Post
	@Path(priority=Path.HIGHEST, value = { "aquisicao/compra" })
	public void compra(CompraModelView compra) {
		validator.validate(compra)
				 .onErrorUsePageOf(this).compra();
		
		this.compra.setCompra(compra);
		this.compra.registerConversation();
		
		result.include("formasPagamentos", formasPagamentosDao.list());
		result.of(this).pagamentos();
	}
	
	@Get("aquisicao/pagamentos")
	public void pagamentos() {		
		compra.registerConversation();
		result.include("formasPagamentos", formasPagamentosDao.list());
	}
	
	@Post("aquisicao/{aquisicao.id}/pagamento/salva")
	public void salvaPagamento(Pagamento pagamento) {
		compra.registerConversation();
		
		pagamento.setTipo(TipoPagamento.DEBITO);
		Integer formaPagamentoId = pagamento.getFormaPagamento().getId();
		pagamento.setFormaPagamento(formasPagamentosDao.find(formaPagamentoId));
		pagamento.setAquisicao(compra.getAquisicao());
		
		result.include("formasPagamentos", formasPagamentosDao.list());
		validator.validate(pagamento)
				 .onErrorUsePageOf(this).pagamentos();
		
		Aquisicao aquisicao = compra.getAquisicao();
		aquisicao.addPagamento(pagamento);
		result.of(this).pagamentos();
	}

	@Transactional
	@Post
	public void salva() {
		compra.registerConversation();
		
		Aquisicao aquisicao = compra.getAquisicao();
		aquisicao.setSituacao(SituacaoAquisicao.OK);
		
		validator.validate(aquisicao);
		
//		validator.addIf(!hasGastos(aquisicao), new I18nMessage("pagamento", "aquisicao.pagamentos.not.empty"));
		validator.addIf(validaPagamento(aquisicao), new I18nMessage("valor", "aquisicao.pagamentos.not.valid", aquisicao.getCustoTotal(), aquisicao.getValor()));
		
		if (validator.hasErrors()) {
			result.include("formasPagamentos", formasPagamentosDao.list());
			validator.onErrorUsePageOf(this).pagamentos();			
		}				 
		
		aquisicoesDao.save(aquisicao);
		compra.endConversation();
		result.include("notice", "Aquisicao salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("aquisicao/removePagamento/{index}")
	public void removePagamento(Integer index) {
		List<Pagamento> pagamentos = compra.getAquisicao().getPagamentos();
		pagamentos.remove(index -1);
		compra.getAquisicao().setPagamentos(pagamentos);
		result.include("notice", "pagamento removido com sucesso.");
		result.include("formasPagamentos", formasPagamentosDao.list());
		result.of(this).pagamentos();
	}

	private boolean validaPagamento(Aquisicao aquisicao) {
		if (aquisicao.getPagamentos() != null && !aquisicao.getPagamentos().isEmpty()) {
			double pagamentos = aquisicao.getCustoTotal().doubleValue();
			double valor = aquisicao.getValor() != null ? aquisicao.getValor().doubleValue() : 0;
			return pagamentos != valor;
		}
		return false;
	}

	@Get("aquisicoes")
	public void lista() {
		List<Aquisicao> aquisicoes = aquisicoesDao.list();
		result.include("aquisicoes", aquisicoes);
	}
	
	@Get("aquisicao/{id}")
	public void deleta(Integer id) {
		result.include("aquisicao", aquisicoesDao.find(id));
	}
	
	@Post("aquisicao/{id}")
	public void deleta(Aquisicao aquisicao) {
		aquisicoesDao.delete(aquisicao);
		result.include("notice", "Aquisicao removida com sucesso.")
		  .redirectTo(this).lista();
	}
	
	@Get("aquisicao/detalhes/{id}")
	public void detalhes(Integer id) {
		Aquisicao aquisicao = aquisicoesDao.find(id);
		result.include("aquisicao", aquisicao);
	}
	
}
