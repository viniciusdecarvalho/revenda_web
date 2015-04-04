package br.edu.ftlf.ads.revenda.service.impl;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.ftlf.ads.revenda.dao.HibernateDaoImpl;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.Usuario;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;

@RequestScoped
public class FuncionariosServiceImpl extends HibernateDaoImpl<Funcionario> implements FuncionariosService {

	/**
	 * @deprecated cdi eyes only
	 */
	public FuncionariosServiceImpl() {
		this(null);
	}
	
	@Inject
	protected FuncionariosServiceImpl(Session session) {
		super(session);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> list() {
		return getCachedCriteria().addOrder(Order.asc(Funcionario.PROPERTY_NOME)).list();
	}
	
	@Override
	public Funcionario login(Usuario usuario) {
		return (Funcionario) getCachedCriteria()
							.add(eq(Funcionario.PROPERTY_LOGIN, usuario.getLogin()))
							.add(eq(Funcionario.PROPERTY_SENHA, usuario.getSenha()))
							.uniqueResult();
	}

	@Override
	public boolean contains(Usuario usuario) {
		return login(usuario) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> getVendedores() {
		return getCachedCriteria().add(eq(Funcionario.PROPERTY_VENDEDOR, true)).list();
	}

}
