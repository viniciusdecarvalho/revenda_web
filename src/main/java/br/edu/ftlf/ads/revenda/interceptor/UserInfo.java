package br.edu.ftlf.ads.revenda.interceptor;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.ftlf.ads.revenda.model.Usuario;

@SessionScoped
@Named("userInfo")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 2071309508582010813L;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogged() {
		return usuario != null;
	}
	
	public void logout() {
		usuario = null;
	}
	
}
