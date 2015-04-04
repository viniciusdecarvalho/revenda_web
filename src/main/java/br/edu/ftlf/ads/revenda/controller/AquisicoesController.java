package br.edu.ftlf.ads.revenda.controller;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;
import br.edu.ftlf.ads.revenda.model.Gasto;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.service.AquisicoesService;
import br.edu.ftlf.ads.revenda.service.ClientesService;
import br.edu.ftlf.ads.revenda.service.FormasPagamentosService;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;
import br.edu.ftlf.ads.revenda.service.VeiculosService;

@Controller
public class AquisicoesController {

	private Logger logger = LoggerFactory.getLogger(AquisicoesController.class);
	
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
	@Post
	public void salva(Aquisicao aquisicao) {
		validator.validate(aquisicao);
		double pagamentos = aquisicao.getCusto().doubleValue();
		double valor = aquisicao.getValor() != null ? aquisicao.getValor().doubleValue() : 0;
		
		validator.addIf(pagamentos < valor, new I18nMessage("valor", "aquisicao.pagamentos.not.valid", pagamentos, valor));
		if (validator.hasErrors()) {
			formAquisicaoIncludes();
			validator.onErrorUsePageOf(this).aquisicao();			
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
	
	@Get
	public void aquisicao() {		
		formulario(new Aquisicao());
	}
	
	private void formulario(Aquisicao aquisicao) {
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
		
		logger.debug("start conversaion -> conversation: {} - aquisicao: {}", conversation.getId(), aquisicao);
	}

	private void formAquisicaoIncludes() {
		result.include("combustiveis", Combustivel.values());
		result.include("vendedores", funcionariosService.getVendedores());
		result.include("veiculos", veiculosService.list());
		result.include("clientes", clientesService.list());
	}
	
	@Get("aquisicao/{id}")
	public void aquisicao(Integer id) {
		formulario(aquisicoesService.find(id));
	}
	
	@Get("aquisicoes")
	public void lista() {
		result.include("aquisicoes", aquisicoesService.list());
	}
	
	@Get("aquisicao/{id}/pagamento")
	public void pagamento() {
		aquisicaoPagamento(new Pagamento());
	}
	
	private void aquisicaoPagamento(Pagamento pagamento) {
		result.include("pagamento", pagamento);
		result.include("formasPagamentos", formasPagamentosService.list());
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		result.include("aquisicao", aquisicao);
		result.include("cid", conversation.getId());
		
		logger.debug("pagamento -> conversation: {} - aquisicao: {}", conversation.getId(), aquisicao);
	}

	@Get("aquisicao/{aquisicao.id}/pagamento/{pagamento.id}")
	public void pagamento(Pagamento pagamento) {
		aquisicaoPagamento(pagamento);
	}
	
	@Get("pagamento/cancela")
	public void cancelaPagamento() {
		result.redirectTo(this).aquisicao();
	}
	
	@IncludeParameters
	@Post("aquisicao/{aquisicao.id}/pagamento/salva")
	public void salvaPagamento(Pagamento pagamento) {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();

		logger.debug("save pagamento -> conversation: {} - aquisicao: {}", conversation.getId(), aquisicao);
		
		pagamento.setDescricao("COMPRA DO VEICULO " + aquisicao.getVeiculo());
		pagamento.setTipo(TipoPagamento.DEBITO);
		
		validator.validate(pagamento)
				 .onErrorUsePageOf(this).pagamento();
		
		
		Gasto gasto = new Gasto();
		gasto.setPagamento(pagamento);
		aquisicao.addGasto(gasto);
		
		result.include("aquisicao", aquisicao)	
			  .redirectTo(this).aquisicao();
	}
}
