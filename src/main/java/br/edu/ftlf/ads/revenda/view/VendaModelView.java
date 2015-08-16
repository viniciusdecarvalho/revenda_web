package br.edu.ftlf.ads.revenda.view;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;

import com.sun.istack.internal.NotNull;

public class VendaModelView {

	@NotNull
	private Integer clienteId;
	@NotNull
	private Integer vendedorId;

	private BigDecimal valorComissao;
	
	@NotNull
	private Date data = new Date();
	
	@Min(0)
	private BigDecimal valor;

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

	public VendaModelView() {
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(Integer vendedorId) {
		this.vendedorId = vendedorId;
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

}
