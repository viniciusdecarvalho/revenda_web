package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.model.Veiculo;
import br.edu.ftlf.ads.revenda.service.VeiculosService;

@Controller
public class VeiculosController {

	private final Result result;
	private final Validator validator;
	private final VeiculosService veiculosService;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected VeiculosController() {
		this(null, null, null);
	}
	
	@Inject
	public VeiculosController(Result result, Validator validator, VeiculosService veiculosService) {
		this.result = result;
		this.validator = validator;
		this.veiculosService = veiculosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(Veiculo veiculo) {
		validator.validate(veiculo)
				 .onErrorUsePageOf(this).form();
		
		veiculosService.save(veiculo);
		result.include("notice", "Veiculo salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("veiculos/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("veiculo", veiculosService.find(id));
	}

	@Get("veiculos/deleta/{id}")
	public void deleta(Integer id) {
		result.include("veiculo", veiculosService.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("veiculos/deleta/{id}")
	public void deleta(Veiculo veiculo) {
		veiculosService.delete(veiculo);
		result.include("notice", "Veiculo removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("veiculo", new Veiculo());
	}
	
	@Get("veiculos/form/{id}")
	public void form(Integer id) {
		result.include("veiculo", veiculosService.find(id));
	}
	
	@Get
	public void lista() {
		result.include("veiculos", veiculosService.list());
	}
	
}
