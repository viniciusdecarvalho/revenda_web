package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Veiculo;

public interface VeiculosDao {

	List<Veiculo> list();
	
	Veiculo find(Integer id);
	
	void save(Veiculo veiculo);
	
	void delete(Veiculo veiculo);

	List<Veiculo> stock();
}
