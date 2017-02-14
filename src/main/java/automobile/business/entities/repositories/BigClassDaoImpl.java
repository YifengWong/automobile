package automobile.business.entities.repositories;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import automobile.business.entities.BigClass;

@Repository
public class BigClassDaoImpl extends AbstractJpaDAO<BigClass> implements BigClassDao {

    public BigClassDaoImpl() {
        super();

        setClazz(BigClass.class);
    }

    // API
	public BigClass findOne(String name) {
		BigClass bigClass = null;
		try {
			bigClass = (BigClass) this.getEntityManager()
	    			.createQuery("from BigClass as obj where obj.name=:n")
	    			.setParameter("n", name).getSingleResult();
		} catch (NoResultException e) {
			bigClass = null;
		}
		return bigClass;
	}

}
