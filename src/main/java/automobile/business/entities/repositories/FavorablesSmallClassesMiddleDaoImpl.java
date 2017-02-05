package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.FavorablesSmallClassesMiddle;


@Repository
public class FavorablesSmallClassesMiddleDaoImpl extends AbstractJpaDAO<FavorablesSmallClassesMiddle> implements FavorablesSmallClassesMiddleDao {

    public FavorablesSmallClassesMiddleDaoImpl() {
        super();
        
        setClazz(FavorablesSmallClassesMiddle.class);
    }

    // API

}
