package automobile.business.entities.repositories;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;

@Repository
public class SmallClassDaoImpl extends AbstractJpaDAO<SmallClass> implements SmallClassDao {

    public SmallClassDaoImpl() {
        super();

        setClazz(SmallClass.class);
    }

    // API
    @SuppressWarnings("unchecked")
	public List<SmallClass> findAllByBigClass(final BigClass bigClass) {
    	return this.getEntityManager()
    			.createQuery("from SmallClass as obj where obj.bigClass=:bc")
    			.setParameter("bc", bigClass).getResultList();
    }

	public SmallClass findOneByName(String name) {
		SmallClass smallClass = null;
		try {
			smallClass = (SmallClass) this.getEntityManager()
	    			.createQuery("from SmallClass as obj where obj.name=:n")
	    			.setParameter("n", name).getSingleResult();
		} catch (NoResultException e) {
			smallClass = null;
		}
		
		return smallClass;
	}

}
