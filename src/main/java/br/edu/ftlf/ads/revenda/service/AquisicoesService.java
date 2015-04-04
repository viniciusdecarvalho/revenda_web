package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Aquisicao;

public interface AquisicoesService {

	List<Aquisicao> list();
	
	Aquisicao find(Integer id);
	
	void save(Aquisicao aquisicao);
	
}
