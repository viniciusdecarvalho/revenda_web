package br.edu.ftlf.ads.revenda.conversation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.model.Venda;
import br.edu.ftlf.ads.revenda.model.Enums.SituacaoVenda;

import com.google.common.collect.Lists;
import com.sun.istack.internal.NotNull;

@Named("venda")
@ConversationScoped
public class VendaConversation implements Serializable {

	private static final long serialVersionUID = -969824305686709688L;
	private static final Logger logger = LoggerFactory
			.getLogger(VendaConversation.class);

	@NotNull
	private Aquisicao aquisicao;
	@NotNull
	private Cliente cliente;
	@NotNull
	private Funcionario vendedor;
	private BigDecimal comissao;
	@NotNull
	private Date data;
	@Min(0)
	private BigDecimal valor;
	@NotEmpty
	private List<Pagamento> pagamentos;

	private final Conversation conversation;

	/**
	 * @deprecated cdi eyes only
	 */
	protected VendaConversation() {
		this(null);
	}

	@Inject
	public VendaConversation(Conversation conversation) {
		this.conversation = conversation;
		this.aquisicao = new Aquisicao();
		this.cliente = new Cliente();
		this.vendedor = new Funcionario();
		this.data = new Date();
		this.pagamentos = Lists.newArrayList();
	}

	public String begin() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		String conversationId = conversation.getId();
		logger.info("begin conversation venda with id: {}", conversationId);
		return conversationId;
	}

	public void end() {
		if (!conversation.isTransient()) {
			logger.info("conversation venda ended with id: {}",
					conversation.getId());
			conversation.end();
		}
	}

	public String getCid() {
		String id = conversation.getId();
		logger.info("conversation venda request with id: {}", id);
		return id;
	}

	public Aquisicao getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public Venda getVenda() {
		Venda venda = new Venda();
		venda.setAquisicao(aquisicao);
		venda.setCliente(cliente);
		venda.setData(data);
		venda.setFuncionario(vendedor);
		venda.setSituacao(SituacaoVenda.OK);
		venda.setValor(valor);
		venda.setValorComissao(comissao);
		venda.setPagamentos(pagamentos);
		return venda;
	}
}
