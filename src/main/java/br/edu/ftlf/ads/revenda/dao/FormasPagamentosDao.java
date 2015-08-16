package br.edu.ftlf.ads.revenda.dao;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.FormaPagamento;

public interface FormasPagamentosDao {
	
	List<FormaPagamento> list();
	
	FormaPagamento find(Integer id);
	
	void save(FormaPagamento formaPagamento);
	
	void delete(FormaPagamento formaPagamento);
	
}
