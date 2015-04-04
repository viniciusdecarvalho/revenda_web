package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Cliente;

public interface ClientesService {
	
	List<Cliente> list();
	
	Cliente find(Integer id);
	
	void save(Cliente cliente);
	
	void delete(Cliente cliente);
	
}
