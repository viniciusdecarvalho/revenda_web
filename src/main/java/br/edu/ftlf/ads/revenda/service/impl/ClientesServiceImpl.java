package br.edu.ftlf.ads.revenda.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.service.ClientesService;

@RequestScoped
public class ClientesServiceImpl extends HibernateDaoImpl<Cliente> implements ClientesService {

	/**
	 * @deprecated cdi eyes only
	 */
	protected ClientesServiceImpl() {
		this(null);
	}
	
	@Inject
	protected ClientesServiceImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> list() {
		return getCachedCriteria().addOrder(Order.asc(Cliente.PROPERTY_RAZAOSOCIAL)).list();
	}
	
}
