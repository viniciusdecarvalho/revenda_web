package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Strings;

public class Fornecedor extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_CPFCNPJ = "cpfCnpj";
	public static final String PROPERTY_RAZAOSOCIAL = "razaoSocial";
	
	private boolean ativo;

	@NotEmpty
	private String cpfCnpj;

	@NotEmpty
	private String razaoSocial;

	private List<Gasto> gastos;

	public Fornecedor() {
	}

	public Fornecedor(Integer id) {
		setId(id);
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {		
		this.cpfCnpj = cpfCnpj;
	}
	
	public boolean isPessoaFisica() {
		if (!Strings.isNullOrEmpty(this.cpfCnpj)) {
			return this.cpfCnpj.length() == 11;
		}
		return true;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Gasto> getGastos() {
		return this.gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setFornecedor(this);
		return gasto;
	}

	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setFornecedor(null);
		return gasto;
	}

}