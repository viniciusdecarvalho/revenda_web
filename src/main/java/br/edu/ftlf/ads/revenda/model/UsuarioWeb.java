package br.edu.ftlf.ads.revenda.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioWeb implements Serializable {
	
	private static final long serialVersionUID = 1699879619352204639L;

	@NotEmpty
	private String login;
	
	@NotEmpty
	private String senha;
	
	private String confirmaSenha;

	public UsuarioWeb() {
	}
	
	public UsuarioWeb(String login, String senha) {
		this.login = login;
		this.senha = senha;
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
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	@Override
	public String toString() {
		return login;
	}
}