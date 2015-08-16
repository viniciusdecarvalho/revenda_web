package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Enums.SituacaoGasto;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;

public class Gasto extends Model {
	private static final long serialVersionUID = 1L;

	@NotNull
	private SituacaoGasto situacao;

	@NotNull
	private Date data;

	@NotEmpty
	private String descricao;

	@NotNull
	private TipoPagamento tipo;

	@NotNull
	@Min(0)
	private BigDecimal valor;

	private FormaPagamento formaPagamento;

	@NotNull
	private Funcionario funcionario;

	@NotNull
	private Aquisicao aquisicao;

	@NotNull
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