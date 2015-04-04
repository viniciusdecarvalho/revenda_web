package br.edu.ftlf.ads.revenda.controller;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Gasto;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.service.AquisicoesService;
import br.edu.ftlf.ads.revenda.service.ClientesService;
import br.edu.ftlf.ads.revenda.service.FormasPagamentosService;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;
import br.edu.ftlf.ads.revenda.service.VeiculosService;

@Controller
public class AquisicoesController {

	private final Result result;
	private final Validator validator;
	private final AquisicoesService aquisicoesService;
	private final FuncionariosService funcionariosService;
	private final ClientesService clientesService;
	private final VeiculosService veiculosService;
	private final Conversation conversation;
	private AquisicaoConversation aquisicaoConversation;
	private FormasPagamentosService formasPagamentosService;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected AquisicoesController() {
		this(null, null, null, null, null, null, null, null, null);
	}
	
	@Inject
	public AquisicoesController(Result result, Validator validator, 
								Conversation conversation, AquisicaoConversation aquisicaoConversation,
								AquisicoesService aquisicoesService, FuncionariosService funcionariosService, 
								ClientesService clientesService, VeiculosService veiculosService, 
								FormasPagamentosService formasPagamentosService) {
		this.result = result;
		this.validator = validator;
		this.conversation = conversation;
		this.aquisicaoConversation = aquisicaoConversation;
		this.aquisicoesService = aquisicoesService;
		this.funcionariosService = funcionariosService;
		this.clientesService = clientesService;
		this.veiculosService = veiculosService;
		this.formasPagamentosService = formasPagamentosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post("aquisicoes/salvaAquisicao")
	public void salvaAquisicao(Aquisicao aquisicao) {
		validator.validate(aquisicao);
		double pagamentos = aquisicao.getCusto().doubleValue();
		double valor = aquisicao.getValor() != null ? aquisicao.getValor().doubleValue() : 0;
		
		validator.addIf(pagamentos < valor, new I18nMessage("valor", "aquisicao.pagamentos.not.valid", pagamentos, valor));
		if (validator.hasErrors()) {
			formAquisicaoIncludes();
			validator.onErrorUsePageOf(this).formAquisicao();			
		}				 
		
		aquisicoesService.save(aquisicao);
		result.include("notice", "Aquisicao salvo com sucesso.");
		endConversation();
		result.redirectTo(this).lista();
	}

	private void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}
	
	@Get("aquisicoes/formAquisicao")
	public void formAquisicao() {		
		form(new Aquisicao());
	}
	
	private void form(Aquisicao aquisicao) {
		formAquisicaoIncludes();
		result.include("aquisicao", aquisicao);
		beginConversation(aquisicao);
	}

	private void beginConversation(Aquisicao aquisicao) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		result.include("cid", conversation.getId());
		aquisicaoConversation.beginConversation(aquisicao);
	}

	private void formAquisicaoIncludes() {
		result.include("combustiveis", Combustivel.values());
		result.include("vendedores", funcionariosService.getVendedores());
		result.include("veiculos", veiculosService.list());
		result.include("clientes", clientesService.list());
	}
	
	@Get("aquisicoes/form/{id}")
	public void formAquisicao(Integer id) {
		form(aquisicoesService.find(id));
	}
	
	@Get("aquisicoes/lista")
	public void lista() {
		result.include("aquisicoes", aquisicoesService.list());
	}
	
	@Get("aquisicoes/{id}/formPagamento")
	public void formPagamento() {
		pagamento(new Pagamento());
	}
	
	private void pagamento(Pagamento pagamento) {
		result.include("pagamento", pagamento);
		result.include("formasPagamentos", formasPagamentosService.list());
		result.include("cid", conversation.getId());
	}

	@Get("aquisicoes/{aquisicao.id}/formPagamento/{pagamento.id}")
	public void formPagamento(Pagamento pagamento) {
		pagamento(pagamento);
	}
	
	@IncludeParameters
	@Post("aquisicoes/{aquisicao.id}/salvaPagamento")
	public void salvaPagamento(Pagamento pagamento) {
		validator.validate(pagamento)
				 .onErrorUsePageOf(this).formPagamento();
		
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		
		Gasto gasto = new Gasto();
		gasto.setPagamento(pagamento);
		aquisicao.addGasto(gasto);
		
		result.include("aquisicao", aquisicao)	
			  .redirectTo(this).formAquisicao();
	}
}
