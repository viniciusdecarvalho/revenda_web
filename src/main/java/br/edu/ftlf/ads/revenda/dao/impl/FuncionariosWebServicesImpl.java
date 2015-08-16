package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.UsuarioWeb;
import br.edu.ftlf.ads.revenda.webservice.FuncionarioDto;
import br.edu.ftlf.ads.revenda.webservice.Usuario;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class FuncionariosWebServicesImpl implements FuncionariosDao {

	private RevendaServices services;

	/**
	 * @deprecated cdi eyes only
	 */
	protected FuncionariosWebServicesImpl() {
		this(null);
	}

	@Inject
	public FuncionariosWebServicesImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<Funcionario> list() {
		return services.listaFuncionarios()
					   .stream()
					   .map(d -> DtoParser.parse(d))
					   .collect(Collectors.toList());
	}
	
	
	@Override
	public Funcionario find(Integer id) {
		FuncionarioDto dto = services.consultaFuncionario(id);
		return DtoParser.parse(dto);
	}

	@Override
	public void save(Funcionario funcionario) {
		FuncionarioDto dto = DtoParser.from(funcionario);
		services.salvaFuncionario(new Holder<FuncionarioDto>(dto));
	}

	@Override
	public void delete(Funcionario funcionario) {
		services.deletaFuncionario(funcionario.getId());
	}

	@Override
	public Funcionario login(UsuarioWeb usuario) {
		FuncionarioDto dto = services.login(new Usuario(){{
			setLogin(usuario.getLogin());
			setSenha(usuario.getSenha());
		}});
		return DtoParser.parse(dto);
	}

	@Override
	public boolean contains(UsuarioWeb usuario) {
		return services.autentica(new Usuario(){{
			setLogin(usuario.getLogin());
			setSenha(usuario.getSenha());
		}});
	}

	@Override
	public List<Funcionario> getVendedores() {
		return services.listaFuncionarios().stream()
					   .filter(f -> f.isVendedor())
					   .map(d -> DtoParser.parse(d))
					   .collect(Collectors.toList());
	}
	
}
