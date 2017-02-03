package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.SmallClass;

@Repository
public class AutosSmallClassesMiddleDaoImpl extends AbstractJpaDAO<AutosSmallClassesMiddle> implements AutosSmallClassesMiddleDao {

    public AutosSmallClassesMiddleDaoImpl() {
        super();

        setClazz(AutosSmallClassesMiddle.class);
    }

    // API
    @SuppressWarnings("unchecked")
	public List<AutosSmallClassesMiddle> findBySmallClass(final SmallClass smallClass) {
    	return this.getEntityManager()
    			.createQuery("from AutosSmallClassesMiddle as obj where obj.smallClass=:sc")
    			.setParameter("sc", smallClass).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<AutosSmallClassesMiddle> findByAutoMakerDetail(final AutoMakerDetail autoMakerDetail) {
    	return this.getEntityManager()
    			.createQuery("from AutosSmallClassesMiddle as obj where obj.autoMakerDetail=:amd")
    			.setParameter("amd", autoMakerDetail).getResultList();
    }

}
