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

}
