package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.Fornecedor;
import br.edu.ftlf.ads.revenda.service.FornecedoresService;

@Controller
public class FornecedoresController {

	private final Result result;
	private final Validator validator;
	private final FornecedoresService fornecedoresService;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected FornecedoresController() {
		this(null, null, null);
	}
	
	@Inject
	public FornecedoresController(Result result, Validator validator, FornecedoresService fornecedorsService) {
		this.result = result;
		this.validator = validator;
		this.fornecedoresService = fornecedorsService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(Fornecedor fornecedor) {
		validator.validate(fornecedor)
				 .onErrorUsePageOf(this).form();
		
		fornecedoresService.save(fornecedor);
		result.include("notice", "Fornecedor salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("fornecedors/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("fornecedor", fornecedoresService.find(id));
	}

	@Get("fornecedors/deleta/{id}")
	public void deleta(Integer id) {
		result.include("fornecedor", fornecedoresService.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("fornecedors/deleta/{id}")
	public void deleta(Fornecedor fornecedor) {
		fornecedoresService.delete(fornecedor);
		result.include("notice", "Fornecedor removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("fornecedor", new Fornecedor());
	}
	
	@Get("fornecedors/form/{id}")
	public void form(Integer id) {
		result.include("fornecedor", fornecedoresService.find(id));
	}
	
	@Get
	public void lista() {
		result.include("fornecedores", fornecedoresService.list());
	}
	
}
