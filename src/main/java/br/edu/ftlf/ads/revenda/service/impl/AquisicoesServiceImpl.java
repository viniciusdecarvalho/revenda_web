package br.edu.ftlf.ads.revenda.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.service.AquisicoesService;

@RequestScoped
public class AquisicoesServiceImpl extends HibernateDaoImpl<Aquisicao> implements AquisicoesService {

	/**
	 * @deprecated cdi eyes only
	 */
	protected AquisicoesServiceImpl() {
		this(null);
	}
	
	@Inject
	protected AquisicoesServiceImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aquisicao> list() {
		return getCachedCriteria().addOrder(Order.desc(Aquisicao.PROPERTY_DATA))
				//.setFetchMode("cliente", FetchMode.JOIN)
				//.setFetchMode("veiculo", FetchMode.JOIN)
				//.setFetchMode("gasto", FetchMode.JOIN)
				.list();
	}
	
	@Override
	public void save(Aquisicao model) {
		super.save(model);
		List<Pagamento> pagamentos = model.getPagamentos();
		for (Pagamento pagamento : pagamentos) {
			getSession().persist(pagamento);
		}
	}
	
}
