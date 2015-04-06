package br.edu.ftlf.ads.revenda.view;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.edu.ftlf.ads.revenda.model.FormaPagamento;

public class PagamentoModelView {

	@NotNull
	private Date data;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private FormaPagamento formaPagamento;
	
	@NotNull
	@Min(0)
	private BigDecimal valor;

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

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
