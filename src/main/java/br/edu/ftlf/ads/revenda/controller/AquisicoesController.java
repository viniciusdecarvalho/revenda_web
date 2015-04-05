package br.edu.ftlf.ads.revenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
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
import br.edu.ftlf.ads.revenda.view.ClienteModelView;
import br.edu.ftlf.ads.revenda.view.CompraModelView;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@ConversationScoped
@Controller
public class AquisicoesController implements Serializable {

	private static final long serialVersionUID = 3470424643529821249L;

	private Logger logger = LoggerFactory.getLogger(AquisicoesController.class);
	
	private final Result result;
	private final Validator validator;
	
	private final AquisicoesService aquisicoesService;
	private final FuncionariosService funcionariosService;
	private final ClientesService clientesService;
	private final VeiculosService veiculosService;
	private final FormasPagamentosService formasPagamentosService;
	
	private final Conversation conversation;
	private final AquisicaoConversation aquisicaoConversation;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected AquisicoesController() {
		this(null, null, null, null, null, null, null, null, null);
	}
	
	@Inject
	public AquisicoesController(Result result, Validator validator, 
								AquisicoesService aquisicoesService, 
								FuncionariosService funcionariosService, 
								ClientesService clientesService, 
								VeiculosService veiculosService, 
								FormasPagamentosService formasPagamentosService,
								Conversation conversation, 
								AquisicaoConversation aquisicaoConversation) {
		this.result = result;
		this.validator = validator;
		this.aquisicoesService = aquisicoesService;
		this.funcionariosService = funcionariosService;
		this.clientesService = clientesService;
		this.veiculosService = veiculosService;
		this.formasPagamentosService = formasPagamentosService;
		
		this.conversation = conversation;
		this.aquisicaoConversation = aquisicaoConversation;
	}
	
	@Get("aquisicao/veiculo")
	public void veiculo() {
		beginConversation();
		conversation(new Aquisicao());
		result.include("veiculos", veiculosService.list());
		result.include("combustiveis", Combustivel.values());
	}

	private void conversation(Aquisicao aquisicao) {
		String conversationId = conversation.getId();
		long timeout = conversation.getTimeout();
		result.include("conversation", conversation);
		result.include("cid", conversationId);
		aquisicaoConversation.setAquisicao(aquisicao);
		result.include("aquisicao", aquisicao);
		logger.info("{} continuing conversation with id: {} -> aquisicao {}", timeout, conversationId, aquisicao);
	}
	
	private void conversation() {
		conversation(aquisicaoConversation.getAquisicao());
	}

	private void beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		String conversationId = conversation.getId();
		result.include("cid", conversationId);
		logger.info("begin conversation with id: {}", conversationId);
	}
	
	private void endConversation() {
		if (!conversation.isTransient()) {
			logger.info("conversation ended with id: {}", conversation.getId());
			conversation.end();
		}
	}
	
	@IncludeParameters
	@Post("aquisicao/veiculo")
	public void veiculo(VeiculoModelView veiculo) {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		validator.validate(veiculo);
		if (validator.hasErrors()) {
			result.include("veiculos", veiculosService.list());
			result.include("combustiveis", Combustivel.values());
			validator.onErrorUsePageOf(this).veiculo();
		}
		aquisicaoConversation.setVeiculo(veiculo);	
		conversation(aquisicao);
		result.redirectTo(this).cliente();
	}
	
	@Get("aquisicao/cliente")
	public void cliente() {
		result.include("clientes", clientesService.list());
		result.include("vendedores", funcionariosService.getVendedores());
		conversation();
	}
	
	@IncludeParameters
	@Post("aquisicao/cliente")
	public void cliente(ClienteModelView cliente) {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		validator.validate(cliente).onErrorUsePageOf(this).cliente();
		if (validator.hasErrors()) {
			result.include("clientes", clientesService.list());
			result.include("vendedores", funcionariosService.getVendedores());
			validator.onErrorUsePageOf(this).cliente();
		}
		aquisicaoConversation.setCliente(cliente);
		conversation(aquisicao);
		result.redirectTo(this).compra();
	}
	
	@Get("aquisicao/compra")
	public void compra() {		
		conversation();
	}
	
	@IncludeParameters
	@Post("aquisicao/compra")
	public void compra(CompraModelView compra) {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		validator.validate(compra).onErrorUsePageOf(this).compra();
		aquisicaoConversation.setCompra(compra);
		conversation(aquisicao);
		result.redirectTo(this).pagamentos();
	}
	
	@Get("aquisicao/pagamentos")
	public void pagamentos() {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		List<Pagamento> pagamentos = Lists.transform(aquisicao.getGastos(), new Function<Gasto, Pagamento>() {
			@Override
			public Pagamento apply(Gasto gasto) {
				return gasto.getPagamento();
			}
		});
		conversation(aquisicao);
		result.include("pagamentos", pagamentos);
	}
	
	@Get("aquisicao/{id}/pagamento")
	public void pagamento() {
		conversation();
		aquisicaoPagamento(new Pagamento());
	}
	
	@Get("aquisicao/{aquisicao.id}/pagamento/{pagamento.id}")
	public void pagamento(Pagamento pagamento) {
		conversation();
		aquisicaoPagamento(pagamento);
	}
	
	private void aquisicaoPagamento(Pagamento pagamento) {
		result.include("pagamento", pagamento);
		result.include("formasPagamentos", formasPagamentosService.list());
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		conversation(aquisicao);
	}

	@IncludeParameters
	@Post("aquisicao/{aquisicao.id}/pagamento/salva")
	public void salvaPagamento(Pagamento pagamento) {
		
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		
		pagamento.setDescricao("COMPRA DO VEICULO " + aquisicao.getVeiculo());
		pagamento.setTipo(TipoPagamento.DEBITO);
		
		validator.validate(pagamento)
				 .onErrorUsePageOf(this).pagamentos();
		
		
		Gasto gasto = new Gasto();
		gasto.setPagamento(pagamento);
		aquisicao.addGasto(gasto);
		
		conversation(aquisicao);
		
		result.include("aquisicao", aquisicao)	
			  .redirectTo(this).pagamentos();
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva() {
		Aquisicao aquisicao = aquisicaoConversation.getAquisicao();
		
		validator.validate(aquisicao);
		
		validator.addIf(hasGastos(aquisicao), new I18nMessage("pagamento", "aquisicao.pagamentos.not.empty"));
		validator.addIf(validaPagamento(aquisicao), new I18nMessage("valor", "aquisicao.pagamentos.not.valid", aquisicao.getCusto(), aquisicao.getValor()));
		
		if (validator.hasErrors()) {
			formAquisicaoIncludes();
			validator.onErrorUsePageOf(this).compra();			
		}				 
		
		aquisicoesService.save(aquisicao);
		result.include("notice", "Aquisicao salvo com sucesso.");
		
		endConversation();
		
		result.redirectTo(this).lista();
	}

	private boolean hasGastos(Aquisicao aquisicao) {
		List<Gasto> gastos = aquisicao.getGastos();
		boolean empty = gastos == null || gastos.isEmpty();
		return !empty;
	}
	
	private boolean validaPagamento(Aquisicao aquisicao) {
		if (aquisicao.getGastos() != null && !aquisicao.getGastos().isEmpty()) {
			double pagamentos = aquisicao.getCusto().doubleValue();
			double valor = aquisicao.getValor() != null ? aquisicao.getValor().doubleValue() : 0;
			return pagamentos < valor;
		}
		return false;
	}

	private void formulario(Aquisicao aquisicao) {
		formAquisicaoIncludes();
		result.include("aquisicao", aquisicao);
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
	
}
