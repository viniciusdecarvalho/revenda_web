package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Enums.SituacaoGasto;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;

/**
 * The persistent class for the gastos database table.
 * 
 */
@Entity
@Table(name = "gastos")
public class Gasto extends Model {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private SituacaoGasto situacao;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data;

	@NotEmpty
	@Column(nullable = false)
	private String descricao;

	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoPagamento tipo;

	@NotNull
	@Min(0)
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "formaPagamentoId", nullable = false)
	private FormaPagamento formaPagamento;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "funcionarioId", nullable = false)
	private Funcionario funcionario;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "aquisicaoId", nullable = false)
	private Aquisicao aquisicao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fornecedorId", nullable = true)
	private Fornecedor fornecedor;

	public SituacaoGasto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoGasto situacao) {
		this.situacao = situacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Aquisicao getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void cancelar() {
		situacao = SituacaoGasto.CANCELADO;
	}

	public void estornar() {
		situacao = SituacaoGasto.ABERTO;
	}

	public void pagar() {
		situacao = SituacaoGasto.PAGO;
	}

}