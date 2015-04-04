package br.edu.ftlf.ads.revenda.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.Veiculo;
import br.edu.ftlf.ads.revenda.service.VeiculosService;

@RequestScoped
public class VeiculosServiceImpl extends HibernateDaoImpl<Veiculo> implements VeiculosService {

	/**
	 * @deprecated cdi eyes only
	 */
	protected VeiculosServiceImpl() {
		this(null);
	}
	
	@Inject
	protected VeiculosServiceImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> list() {
		return getCachedCriteria().addOrder(Order.asc(Veiculo.PROPERTY_MARCA))
								  .addOrder(Order.asc(Veiculo.PROPERTY_MODELO))
								  .addOrder(Order.desc(Veiculo.PROPERTY_ANO))
								  .list();
	}
	
}
