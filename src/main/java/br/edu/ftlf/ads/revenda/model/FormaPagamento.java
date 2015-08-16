package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class FormaPagamento extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_NOME = "nome";

	private boolean ativo;

	private boolean credito;

	private boolean debito;

	@NotEmpty
	private String nome;

	private List<Pagamento> pagamentos;

	public FormaPagamento() {
	}
	
	public FormaPagamento(int id) {
		setId(id);
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isCredito() {
		return this.credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public boolean isDebito() {
		return this.debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setFormaPagamento(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setFormaPagamento(null);

		return pagamento;
	}

}