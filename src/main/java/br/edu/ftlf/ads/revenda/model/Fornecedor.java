package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Strings;

/**
 * The persistent class for the fornecedores database table.
 * 
 */
@Entity
@Table(name="fornecedores")
public class Fornecedor extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_CPFCNPJ = "cpfCnpj";
	public static final String PROPERTY_RAZAOSOCIAL = "razaoSocial";
	
	@Column(nullable=false)
	private boolean ativo;

	@NotEmpty
//	@CpfCnpj
	@Column(nullable=false, length=14)
	private String cpfCnpj;

	@NotEmpty
	@Column(nullable=false, length=50)
	private String razaoSocial;

	@OneToMany(mappedBy="fornecedor")
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
	
	@Transient
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