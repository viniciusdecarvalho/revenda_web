package br.edu.ftlf.ads.revenda.view;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.model.Funcionario;

public class ClienteModelView {

	@NotNull
	private Cliente cliente;
	
	@NotNull
	private Funcionario vendedor;
	
	@Min(0)
	private BigDecimal valorComissao;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

}
