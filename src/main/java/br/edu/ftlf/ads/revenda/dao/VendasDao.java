package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Venda;

public interface VendasDao {

	List<Venda> list();
	
	Venda find(Integer id);
	
	void save(Venda aquisicao);
	
	void delete(Venda aquisicao);
}
