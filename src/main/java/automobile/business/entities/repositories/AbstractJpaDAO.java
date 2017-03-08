package automobile.business.entities.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO<T extends Serializable> {

	private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    
    protected EntityManager  getEntityManager() {
    	return this.entityManager;
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final String id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(final T entity) {
        entityManager.persist(entityManager.merge(entity));
        entityManager.flush();
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
        
    }

    public void delete(final T entity) {
    	entityManager.refresh(entityManager.merge(entity));
    	entityManager.remove(entityManager.merge(entity));
//        entityManager.remove(entity);
    	entityManager.flush();
    }

    public void deleteById(final String entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

}