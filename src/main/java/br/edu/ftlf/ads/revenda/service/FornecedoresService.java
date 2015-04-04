package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Fornecedor;

public interface FornecedoresService {
	
	List<Fornecedor> list();
	
	Fornecedor find(Integer id);
	
	void save(Fornecedor fornecedor);
	
	void delete(Fornecedor fornecedor);
	
}
