package automobile.business.entities.repositories;

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
		return (BigClass) this.getEntityManager()
    			.createQuery("from BigClass as obj where obj.name=:n")
    			.setParameter("n", name).getSingleResult();
	}

}
