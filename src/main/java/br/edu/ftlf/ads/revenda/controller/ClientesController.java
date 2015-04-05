package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.service.ClientesService;

@Controller
public class ClientesController {

	private final Result result;
	private final Validator validator;
	private final ClientesService clientesService;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected ClientesController() {
		this(null, null, null);
	}
	
	@Inject
	public ClientesController(Result result, Validator validator, ClientesService clientesService) {
		this.result = result;
		this.validator = validator;
		this.clientesService = clientesService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(Cliente cliente) {
		validator.validate(cliente)
				 .onErrorUsePageOf(this).form();
		
		clientesService.save(cliente);
		result.include("notice", "Cliente salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("clientes/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("cliente", clientesService.find(id));
	}

	@Get("clientes/deleta/{id}")
	public void deleta(Integer id) {
		result.include("cliente", clientesService.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("clientes/deleta")
	public void deleta(Cliente cliente) {
		clientesService.delete(cliente);
		result.include("notice", "Cliente removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get("clientes/form")
	public void form() {
		result.include("ufs", new String[]{"AM", "CE", "BA", "RJ", "SP", "RN", "RS", "SC", "MG"});
		result.include("cliente", new Cliente());
	}
	
	@Get("clientes/form/{id}")
	public void form(Integer id) {
		result.include("cliente", clientesService.find(id));
	}
	
	@Get("clientes/lista")
	public void lista() {
		result.include("clientes", clientesService.list());
	}
	
}
