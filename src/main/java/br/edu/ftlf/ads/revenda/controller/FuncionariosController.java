package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.UsuarioWeb;

@Controller
public class FuncionariosController {

	private final Result result;
	private final Validator validator;
	private final FuncionariosDao funcionariosDao;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected FuncionariosController() {
		this(null, null, null);
	}
	
	@Inject
	public FuncionariosController(Result result, Validator validator, FuncionariosDao funcionariosService) {
		this.result = result;
		this.validator = validator;
		this.funcionariosDao = funcionariosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(Funcionario funcionario) {
		validator.validate(funcionario)
				 .onErrorUsePageOf(this).form();
		
		funcionariosDao.save(funcionario);
		result.include("notice", "Funcionario salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("funcionarios/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("funcionario", funcionariosDao.find(id));
	}

	@Get("funcionarios/deleta/{id}")
	public void deleta(Integer id) {
		result.include("funcionario", funcionariosDao.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("funcionarios/deleta")
	public void deleta(Funcionario funcionario) {
		funcionariosDao.delete(funcionario);
		result.include("notice", "Funcionario removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("funcionario", new Funcionario());
	}
	
	@Get("funcionarios/form/{id}")
	public void form(Integer id) {
		result.include("funcionario", funcionariosDao.find(id));
	}
	
	@Get
	public void lista() {
		result.include("funcionarios", funcionariosDao.list());
	}
	
	@Get("funcionarios/{id}/editaLogin")
	public void editaUsuario(Integer id) {
		Funcionario funcionario = funcionariosDao.find(id);
		result.include("funcionario", funcionario);
	}
	
	@Transactional
	@IncludeParameters
	@Post("funcionarios/{id}/salvaLogin")
	public void salvaUsuario(Integer id, UsuarioWeb usuario) {
		validator.validate(usuario);
		validator.onErrorUsePageOf(this).editaUsuario(id);
		
		validator.addIf(!usuario.getSenha().equals(usuario.getConfirmaSenha()), new SimpleMessage("senha", "A conformação da senha deve ser igual a senha" ));
		validator.onErrorUsePageOf(this).editaUsuario(id);
		
		Funcionario funcionario = funcionariosDao.find(id);
		funcionario.redefineUsuario(usuario);
		
		funcionariosDao.save(funcionario);
		
		result.include("notice", "Senha alterada com sucesso!");
		result.redirectTo(this).lista();
	}
	
}
