package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class Funcionario extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_NOME = "nome";
	public static final String PROPERTY_LOGIN = "login";
	public static final String PROPERTY_SENHA = "senha";
	public static final String PROPERTY_VENDEDOR = "vendedor";
	
	private boolean ativo;

	private boolean gerente;
		
	private boolean normal;

	private boolean vendedor;
	
	@NotEmpty
	private String cpf;

	@NotEmpty
	private String nome;

	private String login;
	
	private String senha;	
	
	private boolean redefinirSenha;

	private List<Aquisicao> aquisicoes;

	private List<Venda> vendas;
	
	private List<Gasto> gastos;
	
	public Funcionario() {
	}

	public Funcionario(Integer id) {
		setId(id);
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isRedefinirSenha() {
		return redefinirSenha;
	}
	
	public void setRedefinirSenha(boolean redefinirSenha) {
		this.redefinirSenha = redefinirSenha;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isGerente() {
		return this.gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isNormal() {
		return this.normal;
	}

	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	public boolean isVendedor() {
		return this.vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

	public List<Aquisicao> getAquisicoes() {
		return this.aquisicoes;
	}

	public void setAquisicoes(List<Aquisicao> aquisicoes) {
		this.aquisicoes = aquisicoes;
	}

	public Aquisicao addAquisicoe(Aquisicao aquisicoe) {
		getAquisicoes().add(aquisicoe);
		aquisicoe.setFuncionario(this);

		return aquisicoe;
	}

	public Aquisicao removeAquisicoe(Aquisicao aquisicoe) {
		getAquisicoes().remove(aquisicoe);
		aquisicoe.setFuncionario(null);

		return aquisicoe;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setFuncionario(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setFuncionario(null);

		return venda;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setFuncionario(this);

		return gasto;
	}
	
	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setFuncionario(null);

		return gasto;
	}
	
	public String getTipo() {
		if (isGerente()) return "Gerente";
		if (isVendedor()) return "Vendedor";
		return "Normal";
	}
	
	public void redefineUsuario(UsuarioWeb usuario) {
		setLogin(usuario.getLogin());
		setSenha(usuario.getSenha());
		setRedefinirSenha(true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aquisicoes == null) ? 0 : aquisicoes.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((gastos == null) ? 0 : gastos.hashCode());
		result = prime * result + (gerente ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (normal ? 1231 : 1237);
		result = prime * result + (redefinirSenha ? 1231 : 1237);
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((vendas == null) ? 0 : vendas.hashCode());
		result = prime * result + (vendedor ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s %s", nome, cpf);
	}

}