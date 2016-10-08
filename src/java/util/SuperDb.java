
package util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class SuperDb<T> {
	protected Class<T> entityClass;

	@PersistenceContext
	private EntityManager em;
	
	public SuperDb(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void create(T entity) {
		em.persist(entity);
	}

	public void edit(T entity) {
		em.merge(entity);
	}

	public void remove(T entity) {
		em.remove(em.merge(entity));
	}

	public T find(Object id) {
		return em.find(entityClass, id);
	}

	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}	
}
