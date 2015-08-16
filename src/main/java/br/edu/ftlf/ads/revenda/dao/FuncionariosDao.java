package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.UsuarioWeb;

public interface FuncionariosDao {
	
	List<Funcionario> list();
	
	Funcionario find(Integer id);
	
	void save(Funcionario funcionario);
	
	void delete(Funcionario funcionario);
	
	Funcionario login(UsuarioWeb usuario);

	boolean contains(UsuarioWeb usuario);

	List<Funcionario> getVendedores();
	
}
