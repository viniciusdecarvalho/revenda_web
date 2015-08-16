package br.edu.ftlf.ads.revenda.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.conversation.VendaConversation;
import br.edu.ftlf.ads.revenda.dao.AquisicoesDao;
import br.edu.ftlf.ads.revenda.dao.ClientesDao;
import br.edu.ftlf.ads.revenda.dao.FormasPagamentosDao;
import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.dao.VendasDao;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.model.Venda;
import br.edu.ftlf.ads.revenda.view.VendaModelView;

@Controller
public class VendasController {

	private final Result result;
	private final Validator validator;
	private final AquisicoesDao aquisicoesDao;
	private final VendaConversation venda;
	private final ClientesDao clientesDao;
	private final VendasDao vendasDao;
	private final FuncionariosDao funcionariosDao;
	private final FormasPagamentosDao formasPagamentosDao;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected VendasController() {
		this(null, null, null, null, null, null, null, null);
	}

	@Inject
	public VendasController(Result result, 
							Validator validator, 
							VendaConversation venda, 
							VendasDao vendasDao, 
							AquisicoesDao aquisicoesDao, 
							ClientesDao clientesDao, 
							FuncionariosDao funcionariosDao, 
							FormasPagamentosDao formasPagamentosDao) {
		this.result = result;
		this.validator = validator;
		this.vendasDao = vendasDao;
		this.aquisicoesDao = aquisicoesDao;
		this.venda = venda;
		this.clientesDao = clientesDao;
		this.funcionariosDao = funcionariosDao;
		this.formasPagamentosDao = formasPagamentosDao;
	}
	
	@Get("vendas")
	public void lista() {
		List<Venda> vendas = vendasDao.list();
		result.include("vendas", vendas);
	}
	
	@IncludeParameters
	@Get
	public void veiculo(int aquisicaoId) {
		List<Aquisicao> aquisicoes = aquisicoesDao.list();
		result.include("aquisicoes", aquisicoes);
		if (aquisicaoId != 0) {
			Aquisicao aquisicao = aquisicoesDao.find(aquisicaoId);
			result.include("aquisicao", aquisicao);
		}
	}
	
	@Post("venda/veiculo/{id}")
	public void veiculoSelecionado(int aquisicaoId) {
		validator.addIf(aquisicaoId == 0, new SimpleMessage("veiculo", "selecione um veiculo"));
		validator.onErrorForwardTo(this).veiculo(aquisicaoId);
		venda.begin();		
		Aquisicao aquisicao = aquisicoesDao.find(aquisicaoId);
		venda.setAquisicao(aquisicao);
		result.forwardTo(this).cliente();
	}

	@Get
	public void cliente() {
		result.include("clientes", clientesDao.list());
		result.include("vendedores", funcionariosDao.getVendedores());
	}
	
	@Post("vendas/cliente")
	public void cliente(VendaModelView model) {
		
		validator.validate(model).onErrorForwardTo(this).cliente();
		
		Cliente cliente = clientesDao.find(model.getClienteId());
		Funcionario vendedor = funcionariosDao.find(model.getVendedorId());
		venda.setCliente(cliente);
		venda.setVendedor(vendedor);
		venda.setComissao(model.getValorComissao());
		
		result.forwardTo(this).pagamentos();
	}

	@Get("venda/pagamentos")
	public void pagamentos() {		
		result.include("formasPagamentos", formasPagamentosDao.list());
	}
	
	@Post("venda/pagamento/salva")
	public void salvaPagamento(Pagamento pagamento) {
		
		pagamento.setTipo(TipoPagamento.CREDITO);
		pagamento.setFormaPagamento(formasPagamentosDao.find(pagamento.getFormaPagamento().getId()));
		
		result.include("formasPagamentos", formasPagamentosDao.list());
		validator.validate(pagamento)
				 .onErrorForwardTo(this).pagamentos();
		
		venda.getPagamentos().add(pagamento);
		result.forwardTo(this).pagamentos();
	}

	@Post
	public void salva() {
		
		Venda venda = this.venda.getVenda();
		validator.addIf(validaPagamento(venda), new I18nMessage("valor", "venda.pagamentos.not.valid", venda.getCustoTotal(), venda.getValor()));
		validator.validate(venda);
		
		if (validator.hasErrors()) {
			result.include("formasPagamentos", formasPagamentosDao.list());
			validator.onErrorForwardTo(this).pagamentos();			
		}				 
		
		vendasDao.save(venda);
		this.venda.end();
		result.include("notice", "Venda salva com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("venda/removePagamento/{index}")
	public void removePagamento(Integer index) {
		venda.getPagamentos().remove(index -1);
		result.include("notice", "pagamento removido com sucesso.");
		result.include("formasPagamentos", formasPagamentosDao.list());
		result.forwardTo(this).pagamentos();
	}

	private boolean validaPagamento(Venda venda) {
		if (venda.getPagamentos() != null && !venda.getPagamentos().isEmpty()) {
			double pagamentos = venda.getCustoTotal().doubleValue();
			double valor = venda.getValor() != null ? venda.getValor().doubleValue() : 0;
			return pagamentos != valor;
		}
		return false;
	}
	
}
