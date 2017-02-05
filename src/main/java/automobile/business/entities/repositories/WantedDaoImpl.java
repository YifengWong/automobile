package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.Wanted;


@Repository
public class WantedDaoImpl extends AbstractJpaDAO<Wanted> implements WantedDao {

    public WantedDaoImpl() {
        super();
        
        setClazz(Wanted.class);
    }

    // API

}
