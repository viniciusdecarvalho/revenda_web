package br.edu.ftlf.ads.revenda.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.FormaPagamento;
import br.edu.ftlf.ads.revenda.service.FormasPagamentosService;

@RequestScoped
public class FormasPagamentosServiceImpl extends HibernateDaoImpl<FormaPagamento> implements FormasPagamentosService {

	/**
	 * @deprecated cdi eyes only
	 */
	protected FormasPagamentosServiceImpl() {
		this(null);
	}
	
	@Inject
	protected FormasPagamentosServiceImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FormaPagamento> list() {
		return getCachedCriteria().addOrder(Order.asc(FormaPagamento.PROPERTY_NOME))
								  .list();
	}
	
}
