package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;

public class Pagamento extends Model {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String descricao;

	@NotNull
	private TipoPagamento tipo;

	@NotNull
	@Min(0)
	private BigDecimal valor;

	private FormaPagamento formaPagamento;
	
	@NotNull
	private Aquisicao aquisicao;

	public Pagamento() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPagamento getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public Aquisicao getAquisicao() {
		return aquisicao;
	}
	
	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}
	
}