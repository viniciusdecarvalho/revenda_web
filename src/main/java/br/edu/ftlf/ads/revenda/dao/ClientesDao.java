package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Cliente;

public interface ClientesDao {
	
	List<Cliente> list();
	
	Cliente find(Integer id);
	
	void save(Cliente cliente);
	
	void delete(Cliente cliente);
	
}
