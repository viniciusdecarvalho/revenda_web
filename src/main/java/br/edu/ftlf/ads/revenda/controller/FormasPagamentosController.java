package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.FormaPagamento;
import br.edu.ftlf.ads.revenda.service.FormasPagamentosService;

@Controller
public class FormasPagamentosController {

	private final Result result;
	private final Validator validator;
	private final FormasPagamentosService formaPagamentosService;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected FormasPagamentosController() {
		this(null, null, null);
	}
	
	@Inject
	public FormasPagamentosController(Result result, Validator validator, FormasPagamentosService formaPagamentosService) {
		this.result = result;
		this.validator = validator;
		this.formaPagamentosService = formaPagamentosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(FormaPagamento formaPagamento) {
		validator.validate(formaPagamento)
				 .onErrorUsePageOf(this).form();
		
		formaPagamentosService.save(formaPagamento);
		result.include("notice", "FormaPagamento salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("formaPagamentos/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("formaPagamento", formaPagamentosService.find(id));
	}

	@Get("formaPagamentos/deleta/{id}")
	public void deleta(Integer id) {
		result.include("formaPagamento", formaPagamentosService.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("formaPagamentos/deleta/{id}")
	public void deleta(FormaPagamento formaPagamento) {
		formaPagamentosService.delete(formaPagamento);
		result.include("notice", "FormaPagamento removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("formaPagamento", new FormaPagamento());
	}
	
	@Get("formaPagamentos/form/{id}")
	public void form(Integer id) {
		result.include("formaPagamento", formaPagamentosService.find(id));
	}
	
	@Get
	public void lista() {
		result.include("formaPagamentos", formaPagamentosService.list());
	}
	
}
