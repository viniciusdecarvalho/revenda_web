package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.dao.FormasPagamentosDao;
import br.edu.ftlf.ads.revenda.model.FormaPagamento;

@Controller
public class FormasPagamentosController {

	private final Result result;
	private final Validator validator;
	private final FormasPagamentosDao formaPagamentosDao;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected FormasPagamentosController() {
		this(null, null, null);
	}
	
	@Inject
	public FormasPagamentosController(Result result, Validator validator, FormasPagamentosDao formaPagamentosService) {
		this.result = result;
		this.validator = validator;
		this.formaPagamentosDao = formaPagamentosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(FormaPagamento formaPagamento) {
		validator.validate(formaPagamento)
				 .onErrorUsePageOf(this).form();
		
		formaPagamentosDao.save(formaPagamento);
		result.include("notice", "FormaPagamento salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("formaPagamentos/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("formaPagamento", formaPagamentosDao.find(id));
	}

	@Get("formaPagamentos/deleta/{id}")
	public void deleta(Integer id) {
		result.include("formaPagamento", formaPagamentosDao.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("formaPagamentos/deleta")
	public void deleta(FormaPagamento formaPagamento) {
		formaPagamentosDao.delete(formaPagamento);
		result.include("notice", "FormaPagamento removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("formaPagamento", new FormaPagamento());
	}
	
	@Get("formaPagamentos/form/{id}")
	public void form(Integer id) {
		result.include("formaPagamento", formaPagamentosDao.find(id));
	}
	
	@Get
	public void lista() {
		result.include("formaPagamentos", formaPagamentosDao.list());
	}
	
}
