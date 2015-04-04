package br.edu.ftlf.ads.revenda.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.Fornecedor;
import br.edu.ftlf.ads.revenda.service.FornecedoresService;

@RequestScoped
public class FornecedoresServiceImpl extends HibernateDaoImpl<Fornecedor> implements FornecedoresService {

	/**
	 * @deprecated cdi eyes only
	 */
	protected FornecedoresServiceImpl() {
		this(null);
	}
	
	@Inject
	protected FornecedoresServiceImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> list() {
		return getCachedCriteria().addOrder(Order.asc(Fornecedor.PROPERTY_RAZAOSOCIAL)).list();
	}
	
}
