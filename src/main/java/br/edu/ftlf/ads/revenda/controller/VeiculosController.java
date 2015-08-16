package br.edu.ftlf.ads.revenda.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.dao.VeiculosDao;
import br.edu.ftlf.ads.revenda.model.Veiculo;

@Controller
public class VeiculosController {

	private final Result result;
	private final Validator validator;
	private final VeiculosDao veiculosDao;
	
	/**
	 * cdi eyes 
	 * @deprecated 
	 */
	protected VeiculosController() {
		this(null, null, null);
	}
	
	@Inject
	public VeiculosController(Result result, Validator validator, VeiculosDao veiculosService) {
		this.result = result;
		this.validator = validator;
		this.veiculosDao = veiculosService;
	}
	
	@Transactional
	@IncludeParameters
	@Post
	public void salva(Veiculo veiculo) {
		validator.validate(veiculo)
				 .onErrorUsePageOf(this).form();
		
		veiculosDao.save(veiculo);
		result.include("notice", "Veiculo salvo com sucesso.");
		result.redirectTo(this).lista();
	}
	
	@Get("veiculos/detalhes/{id}")
	public void detalhes(Integer id) {
		result.include("veiculo", veiculosDao.find(id));
	}

	@Get("veiculos/deleta/{id}")
	public void deleta(Integer id) {
		result.include("veiculo", veiculosDao.find(id));
	}

	@Transactional
	@IncludeParameters
	@Post("veiculos/deleta")
	public void deleta(Veiculo veiculo) {
		veiculosDao.delete(veiculo);
		result.include("notice", "Veiculo removido com sucesso.")
			  .redirectTo(this).lista();
	}
	
	@Get
	public void form() {
		result.include("veiculo", new Veiculo());
	}
	
	@Get("veiculos/form/{id}")
	public void form(Integer id) {
		result.include("veiculo", veiculosDao.find(id));
	}
	
	@Get
	public void lista() {
		result.include("veiculos", veiculosDao.list());
	}
	
}
