package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Aquisicao;

public interface AquisicoesDao {

	List<Aquisicao> list();
	
	Aquisicao find(Integer id);
	
	void save(Aquisicao aquisicao);
	
	void delete(Aquisicao aquisicao);
}
