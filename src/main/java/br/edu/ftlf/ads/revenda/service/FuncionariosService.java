package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.Usuario;

public interface FuncionariosService {
	
	List<Funcionario> list();
	
	Funcionario find(Integer id);
	
	void save(Funcionario funcionario);
	
	void delete(Funcionario funcionario);
	
	Funcionario login(Usuario usuario);

	boolean contains(Usuario usuario);

	List<Funcionario> getVendedores();
	
}
