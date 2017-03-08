package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.FavorablesSmallClassesMiddle;
import automobile.business.entities.SmallClass;


@Repository
public class FavorablesSmallClassesMiddleDaoImpl extends AbstractJpaDAO<FavorablesSmallClassesMiddle> implements FavorablesSmallClassesMiddleDao {

    public FavorablesSmallClassesMiddleDaoImpl() {
        super();
        
        setClazz(FavorablesSmallClassesMiddle.class);
    }

    // API
    @SuppressWarnings("unchecked")
	public List<FavorablesSmallClassesMiddle> findBySmallClass(final SmallClass smallClass) {
    	return this.getEntityManager()
    			.createQuery("from FavorablesSmallClassesMiddle as obj where obj.smallClass=:sc")
    			.setParameter("sc", smallClass).getResultList();
    }

}
