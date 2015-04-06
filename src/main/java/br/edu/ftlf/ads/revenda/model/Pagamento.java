package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;

/**
 * The persistent class for the pagamentos database table.
 * 
 */
@Entity
@Table(name="pagamentos")
public class Pagamento extends Model {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(nullable=false)
	private String descricao;

	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private TipoPagamento tipo;

	@NotNull
	@Min(0)
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="formaPagamentoId", nullable=false)
	private FormaPagamento formaPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="aquisicaoId", nullable=false)
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