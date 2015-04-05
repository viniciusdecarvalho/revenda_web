package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;

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

	@OneToOne(mappedBy="pagamento")
	private Gasto gasto;

	@ManyToOne
	@JoinColumn(name="formaPagamentoId", nullable=false)
	private FormaPagamento formaspagamento;

	public Pagamento() {
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public FormaPagamento getFormaspagamento() {
		return this.formaspagamento;
	}

	public void setFormaspagamento(FormaPagamento formaspagamento) {
		this.formaspagamento = formaspagamento;
	}
	
	public Gasto getGastos() {
		return gasto;
	}
	
	public void setGastos(Gasto gasto) {
		gasto.setPagamento(this);
		this.gasto = gasto;
	}

}