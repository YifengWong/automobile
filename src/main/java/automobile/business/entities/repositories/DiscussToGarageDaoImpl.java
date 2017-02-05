package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.DiscussToGarage;


@Repository
public class DiscussToGarageDaoImpl extends AbstractJpaDAO<DiscussToGarage> implements DiscussToGarageDao {

    public DiscussToGarageDaoImpl() {
        super();
        
        setClazz(DiscussToGarage.class);
    }

    // API

}
