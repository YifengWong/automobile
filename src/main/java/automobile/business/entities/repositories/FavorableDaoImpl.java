package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.Favorable;


@Repository
public class FavorableDaoImpl extends AbstractJpaDAO<Favorable> implements FavorableDao {

    public FavorableDaoImpl() {
        super();
        
        setClazz(Favorable.class);
    }

    // API

}
