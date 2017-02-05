package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.WantedsSmallClassesMiddle;


@Repository
public class WantedsSmallClassesMiddleDaoImpl extends AbstractJpaDAO<WantedsSmallClassesMiddle> implements WantedsSmallClassesMiddleDao {

    public WantedsSmallClassesMiddleDaoImpl() {
        super();
        
        setClazz(WantedsSmallClassesMiddle.class);
    }

    // API

}
