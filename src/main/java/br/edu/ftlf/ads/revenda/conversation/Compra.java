package br.edu.ftlf.ads.revenda.conversation;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.view.ClienteModelView;
import br.edu.ftlf.ads.revenda.view.CompraModelView;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

@Named("compra")
@ConversationScoped
public class Compra implements Serializable {

	private static final long serialVersionUID = 8931139070936694408L;
	private static final Logger logger = LoggerFactory.getLogger(Compra.class);

	private final Conversation conversation;
	
	private Aquisicao aquisicao;

	private VeiculoModelView veiculo;
	private ClienteModelView cliente;
	private CompraModelView compra;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected Compra() {
		this(null);
	}
	
	@Inject
	public Compra(Conversation conversation) {
		this.conversation = conversation;
		this.aquisicao = new Aquisicao();
	}

	public void fill(VeiculoModelView modelView) {
		if (modelView == null) return;
		aquisicao.setVeiculo(modelView.getVeiculo());
		aquisicao.setUf(modelView.getUf());
		aquisicao.setCidade(modelView.getCidade());
		aquisicao.setCor(modelView.getCor());
		aquisicao.setCombustivel(modelView.getCombustivel());
		aquisicao.setKm(modelView.getKm());
	}

	public void fill(ClienteModelView modelView) {
		if (modelView == null) return;
		aquisicao.setCliente(modelView.getCliente());
		aquisicao.setFuncionario(modelView.getVendedor());
		aquisicao.setValorComissao(modelView.getValorComissao());
	}

	public void fill(CompraModelView compra) {
		if (compra == null) return;
		aquisicao.setData(compra.getData());
		aquisicao.setValor(compra.getValor());
		aquisicao.setValorPedido(compra.getValorPedido());
	}
	
	public String registerConversation() {
		String conversationId = conversation.getId();		
		logger.info("continuing conversation with id: {} -> aquisicao {}", conversationId, aquisicao);
		return conversationId;
	}
	
	public String beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		String conversationId = conversation.getId();
		logger.info("begin conversation with id: {}", conversationId);
		return conversationId;
	}
	
	public void endConversation() {
		if (!conversation.isTransient()) {
			logger.info("conversation ended with id: {}", conversation.getId());
			conversation.end();
		}
	}
	
	public Aquisicao getAquisicao() {
		return aquisicao;
	}

	public VeiculoModelView getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModelView veiculo) {
		this.veiculo = veiculo;
		fill(veiculo);
	}

	public ClienteModelView getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModelView cliente) {
		this.cliente = cliente;
		fill(cliente);
	}

	public CompraModelView getCompra() {
		return compra;
	}

	public void setCompra(CompraModelView compra) {
		this.compra = compra;
		fill(compra);
	}
	
	public String getCid() {
		return conversation.getId();
	}

}
