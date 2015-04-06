package br.edu.ftlf.ads.revenda.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.conversation.Compra;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Enums.SituacaoAquisicao;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;
import br.edu.ftlf.ads.revenda.model.Gasto;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.service.AquisicoesService;
import br.edu.ftlf.ads.revenda.service.ClientesService;
import br.edu.ftlf.ads.revenda.service.FormasPagamentosService;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;
import br.edu.ftlf.ads.revenda.service.VeiculosService;
import br.edu.ftlf.ads.revenda.view.ClienteModelView;
import br.edu.ftlf.ads.revenda.view.CompraModelView;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

@Controller
public class AquisicoesController {

	private final Result result;
	private final Validator validator;
	
	private final AquisicoesService aquisicoesService;
	private final FuncionariosService funcionariosService;
	private final ClientesService clientesService;
	private final VeiculosService veiculosService;
	private final FormasPagamentosService formasPagamentosService;
	
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
								AquisicoesService aquisicoesService, 
								FuncionariosService funcionariosService, 
								ClientesService clientesService, 
								VeiculosService veiculosService, 
								FormasPagamentosService formasPagamentosService,
								Compra aquisicaoConversation) {
		this.result = result;
		this.validator = validator;
		this.aquisicoesService = aquisicoesService;
		this.funcionariosService = funcionariosService;
		this.clientesService = clientesService;
		this.veiculosService = veiculosService;
		this.formasPagamentosService = formasPagamentosService;
		this.compra = aquisicaoConversation;
	}
	
	@Get("aquisicao/veiculo")
	public void veiculo() {
		compra.beginConversation();		
		result.include("veiculos", veiculosService.list());
		result.include("combustiveis", Combustivel.values());
	}
		
	@IncludeParameters
	@Post("aquisicao/veiculo")
	public void veiculo(VeiculoModelView veiculo) {
		compra.registerConversation();
		validator.validate(veiculo);
		if (validator.hasErrors()) {
			result.include("veiculos", veiculosService.list());
			result.include("combustiveis", Combustivel.values());
			validator.onErrorUsePageOf(this).veiculo();
		}
		compra.setVeiculo(veiculo);
		
		result.include("clientes", clientesService.list());
		result.include("vendedores", funcionariosService.getVendedores());
		result.of(this).cliente();
	}
	
	@Get("aquisicao/cliente")
	public void cliente() {
		compra.registerConversation();
		result.include("clientes", clientesService.list());
		result.include("vendedores", funcionariosService.getVendedores());
	}
	
	@IncludeParameters
	@Post("aquisicao/cliente")
	public void cliente(ClienteModelView cliente) {
		compra.registerConversation();
		validator.validate(cliente);
		if (validator.hasErrors()) {
			result.include("clientes", clientesService.list());
			result.include("vendedores", funcionariosService.getVendedores());
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
	@Post("aquisicao/compra")
	public void compra(CompraModelView compra) {
		validator.validate(compra)
				 .onErrorUsePageOf(this).compra();
		
		this.compra.setCompra(compra);
		this.compra.registerConversation();
		
		result.include("formasPagamentos", formasPagamentosService.list());
		result.of(this).pagamentos();
	}
	
	@Get("aquisicao/pagamentos")
	public void pagamentos() {		
		compra.registerConversation();
		result.include("formasPagamentos", formasPagamentosService.list());
	}
	
	@IncludeParameters
	@Post("aquisicao/{aquisicao.id}/pagamento/salva")
	public void salvaPagamento(Pagamento pagamento) {
		compra.registerConversation();
		
		pagamento.setTipo(TipoPagamento.DEBITO);
		Integer formaPagamentoId = pagamento.getFormaPagamento().getId();
		pagamento.setFormaPagamento(formasPagamentosService.find(formaPagamentoId));
		pagamento.setAquisicao(compra.getAquisicao());
		
		result.include("formasPagamentos", formasPagamentosService.list());
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
			result.include("formasPagamentos", formasPagamentosService.list());
			validator.onErrorUsePageOf(this).pagamentos();			
		}				 
		
		aquisicoesService.save(aquisicao);
		compra.endConversation();
		result.include("notice", "Aquisicao salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("aquisicao/removePagamento/{index}")
	public void removePagamento(Integer index) {
		List<Pagamento> pagamentos = compra.getAquisicao().getPagamentos();
		pagamentos.remove(index);
		result.include("notice", "pagamento removido com sucesso.");
		result.include("formasPagamentos", formasPagamentosService.list());
		result.of(this).pagamentos();
	}

	private boolean hasGastos(Aquisicao aquisicao) {
		List<Gasto> gastos = aquisicao.getGastos();
		boolean empty = gastos == null || gastos.isEmpty();
		return !empty;
	}
	
	private boolean validaPagamento(Aquisicao aquisicao) {
		if (aquisicao.getPagamentos() != null && !aquisicao.getPagamentos().isEmpty()) {
			double pagamentos = aquisicao.getCustoTotal().doubleValue();
			double valor = aquisicao.getValor() != null ? aquisicao.getValor().doubleValue() : 0;
			return pagamentos < valor;
		}
		return false;
	}

	@Get("aquisicoes")
	public void lista() {
		result.include("aquisicoes", aquisicoesService.list());
	}
	
	@Get("aquisicao/{id}")
	public void deleta(Integer id) {
		result.include("aquisicao", aquisicoesService.find(id));
	}
	
}
