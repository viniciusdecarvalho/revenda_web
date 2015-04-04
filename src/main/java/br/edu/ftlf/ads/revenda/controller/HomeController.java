package br.edu.ftlf.ads.revenda.controller;

import java.util.Arrays;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.interceptor.Public;
import br.edu.ftlf.ads.revenda.interceptor.UserInfo;
import br.edu.ftlf.ads.revenda.model.Usuario;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;

@Controller
public class HomeController {

	private Result result;
	private FuncionariosService funcionarios;
	private UserInfo info;
	private Validator validator;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected HomeController() {
		this(null, null, null, null);
	}
	
	@Inject
	public HomeController(Result result, Validator validator, FuncionariosService funcionarios, UserInfo info) {
		this.result = result;
		this.validator = validator;
		this.funcionarios = funcionarios;
		this.info = info;
	}
	
	@Get({"/home", "/"})
	public void home() {}
	
	@Public
	@Get({"/login"})
	public void login() {}
	
	@IncludeParameters
	@Public
	@Post("/login")
	public void login(Usuario usuario) {

		validator.validate(usuario)
				 .onErrorUsePageOf(this).login();
				 
		boolean contains = funcionarios.contains(usuario);
		if (contains) {
			info.setUsuario(usuario);
			result.redirectTo(this).home();
		} else {
			Message message = new SimpleMessage("login", "Usuario e/ou senha invalidos");
			result.include("errors", Arrays.asList(message));
		}
			
	}

	@Get("/logout")
	public void logout() {
		info.logout();
		result.redirectTo(this).login();
	}
}
