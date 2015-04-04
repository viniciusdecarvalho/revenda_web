package br.edu.ftlf.ads.revenda.service;

import java.util.List;

import br.edu.ftlf.ads.revenda.model.FormaPagamento;

public interface FormasPagamentosService {
	
	List<FormaPagamento> list();
	
	FormaPagamento find(Integer id);
	
	void save(FormaPagamento formaPagamento);
	
	void delete(FormaPagamento formaPagamento);
	
}
