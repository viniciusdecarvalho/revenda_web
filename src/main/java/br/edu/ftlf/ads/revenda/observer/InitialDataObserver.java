package br.edu.ftlf.ads.revenda.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.edu.ftlf.ads.revenda.model.Funcionario;

@Dependent
public class InitialDataObserver {
	
	private SessionFactory factory;

	@Inject 
	public InitialDataObserver(SessionFactory factory) {
		this.factory = factory;
	}

	public void insert(@Observes VRaptorInitialized event) {

		Session session = null;
		
		try {
			
			session = factory.openSession();
			
			if (adminExists(session)) {
				return;
			}
			
			session.getTransaction().begin();
			
			Funcionario admin = new Funcionario();
			admin.setLogin("admin");
			admin.setSenha("admin");
			admin.setAtivo(true);
			admin.setCpf("00000000000");
			admin.setGerente(true);
			admin.setNome("Administrador");

			session.persist(admin);
			session.getTransaction().commit();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		} 
	}

	private boolean adminExists(Session session) {
		return session.createCriteria(Funcionario.class).add(Restrictions.eq("login", "admin")).uniqueResult() != null;
	}
}