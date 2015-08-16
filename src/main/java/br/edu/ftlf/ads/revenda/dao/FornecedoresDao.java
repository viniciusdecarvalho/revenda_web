package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.Fornecedor;

public interface FornecedoresDao {
	
	List<Fornecedor> list();
	
	Fornecedor find(Integer id);
	
	void save(Fornecedor fornecedor);
	
	void delete(Fornecedor fornecedor);
	
}
