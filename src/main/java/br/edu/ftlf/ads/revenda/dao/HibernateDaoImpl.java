package br.edu.ftlf.ads.revenda.dao;

import static org.hibernate.criterion.MatchMode.EXACT;
import static org.hibernate.criterion.MatchMode.START;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import br.edu.ftlf.ads.revenda.model.Model;

public abstract class HibernateDaoImpl<T extends Model>
		implements Dao<T, Integer> {

	private static final byte FLUSH_COUNT = 20;

	private Session session;
	private Class<T> modelClass;

	protected HibernateDaoImpl(Session session) {
		this.session = session;
		this.modelClass = getParameterizedClass(getClass());
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getParameterizedClass(Class<?> clazz) {
		ParameterizedType type = (ParameterizedType) ((Class<?>) clazz).getGenericSuperclass();
		return (Class<T>) type.getActualTypeArguments()[0];
	}

	public Session getSession() {
		return session;
	}

	public Class<T> getModelClass() {
		return modelClass;
	}

	@Override
	public void save(T model) {
		session.saveOrUpdate(model);
	}

	@Override
	public void saveAll(Collection<T> models) {
		Iterator<? extends T> it = models.iterator();
		for (int i = 0; it.hasNext(); i++) {
			save(it.next());
			if (i > 0 & i % FLUSH_COUNT == 0) {
				flushAndClearSession();
			}
		}
	}

	private void flushAndClearSession() {
		session.flush();
		session.clear();
	}

	@Override
	public void delete(Integer id) {
		session.delete(find(id));
	}
	
	@Override
	public void delete(T model) {
		session.delete(model);
	}

	@Override
	public void deleteAll(Collection<T> models) {
		Iterator<? extends T> it = models.iterator();
		for (int i = 0; it.hasNext(); i++) {
			delete(it.next());
			if (i > 0 & i % FLUSH_COUNT == 0) {
				flushAndClearSession();
			}
		}
	}

	@Override
	public List<T> list(Integer start, Integer limit) {
		return paginateCriteria(getCriteria(), start, limit);
	}

	@SuppressWarnings("unchecked")
	public List<T> paginateCriteria(Criteria criteria, Integer start,
			Integer limit) {
		return criteria.setFirstResult(start).setMaxResults(limit).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return getCachedCriteria().list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(T model) {
		Example example = getExample(model, true, START);
		return getCriteria().add(example).list();
	}

	public Criteria getCriteria() {
		return session.createCriteria(modelClass);
	}

	public Criteria getCachedCriteria() {
		return getCriteria().setCacheable(true);		
	}
	
	public DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(modelClass);
	}
	
	public void addOrders(Criteria criteria, Collection<Order> orders) {
		if (orders == null) return;
		for (Order order : orders) {
			criteria.addOrder(order);
		}
	}

	@Override
	public List<T> list(T model, Integer start, Integer limit) {
		Example example = getExample(model, true, START);
		Criteria criteria = getCriteria().add(example);
		return paginateCriteria(criteria, start, limit);
	}

	public Example getExample(T model, boolean ignoreCase, MatchMode mode) {
		Example example = Example.create(model);
		if (mode != null) 
			example.enableLike(mode);
		if (ignoreCase) 
			example.ignoreCase(); 
		return example;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Integer id) {
		return (T) session.load(modelClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id) {
		return (T) session.get(modelClass, id);
	}
	
	@Override
	public Long total() {
		return (Long) getCachedCriteria()
					.setProjection(Projections.rowCount()).uniqueResult();
	}

	public Query query(String hql) {
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		return query;
	}
	
	@Override
	public boolean contains(T model) {
		return findBy(model) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBy(T model) {
		Example example = getExample(model, false, EXACT);
		return getCachedCriteria().add(example).list();
	}
	
}