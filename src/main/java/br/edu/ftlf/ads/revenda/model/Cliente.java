package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class Cliente extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_RAZAOSOCIAL = "razaoSocial";
	public static final String PROPERTY_CPFCNPJ = "cpfCnpj";
	
	private boolean ativo;

	private Endereco endereco = new Endereco();
	
	private Contato contato = new Contato();
	
	@NotEmpty
	private String cpfCnpj;
	
	public enum Tipo{FISICA, JURIDICA}
	
	private Tipo tipo = Tipo.FISICA;

	@NotEmpty
	private String razaoSocial;

	private List<Aquisicao> aquisicoes;

	private List<Venda> vendas;

	public Cliente() {
	}

	public Cliente(Integer id) {
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
		if (this.cpfCnpj != null && this.cpfCnpj.length() == 14) {
			this.tipo = Tipo.JURIDICA;		
		} else {
			this.tipo = Tipo.FISICA;
		}
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	protected void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Aquisicao> getAquisicoes() {
		return this.aquisicoes;
	}

	public void setAquisicoes(List<Aquisicao> aquisicoes) {
		this.aquisicoes = aquisicoes;
	}

	public Aquisicao addAquisicao(Aquisicao aquisicao) {
		getAquisicoes().add(aquisicao);
		aquisicao.setCliente(this);

		return aquisicao;
	}

	public Aquisicao removeAquisicao(Aquisicao aquisicao) {
		getAquisicoes().remove(aquisicao);
		aquisicao.setCliente(null);

		return aquisicao;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setCliente(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setCliente(null);

		return venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aquisicoes == null) ? 0 : aquisicoes.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s %s", razaoSocial, cpfCnpj);
	}

}