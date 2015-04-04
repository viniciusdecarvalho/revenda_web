package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Veiculo;

public interface VeiculosService {

	List<Veiculo> list();
	
	Veiculo find(Integer id);
	
	void save(Veiculo veiculo);
	
	void delete(Veiculo veiculo);
}
