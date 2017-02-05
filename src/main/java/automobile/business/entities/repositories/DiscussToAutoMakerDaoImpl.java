package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.DiscussToAutoMaker;


@Repository
public class DiscussToAutoMakerDaoImpl extends AbstractJpaDAO<DiscussToAutoMaker> implements DiscussToAutoMakerDao {

    public DiscussToAutoMakerDaoImpl() {
        super();
        
        setClazz(DiscussToAutoMaker.class);
    }

    // API

}
