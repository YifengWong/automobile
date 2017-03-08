package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.SmallClass;
import automobile.business.entities.WantedsSmallClassesMiddle;


@Repository
public class WantedsSmallClassesMiddleDaoImpl extends AbstractJpaDAO<WantedsSmallClassesMiddle> implements WantedsSmallClassesMiddleDao {

    public WantedsSmallClassesMiddleDaoImpl() {
        super();
        
        setClazz(WantedsSmallClassesMiddle.class);
    }

    // API
    @SuppressWarnings("unchecked")
	public List<WantedsSmallClassesMiddle> findBySmallClass(final SmallClass smallClass) {
    	return this.getEntityManager()
    			.createQuery("from WantedsSmallClassesMiddle as obj where obj.smallClass=:sc")
    			.setParameter("sc", smallClass).getResultList();
    }
}
