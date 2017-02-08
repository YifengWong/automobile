package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.DiscussToAutoMaker;


@Repository
public class DiscussToAutoMakerDaoImpl extends AbstractJpaDAO<DiscussToAutoMaker> implements DiscussToAutoMakerDao {

    public DiscussToAutoMakerDaoImpl() {
        super();
        
        setClazz(DiscussToAutoMaker.class);
    }
    
    
    // API
	@SuppressWarnings("unchecked")
	public List<DiscussToAutoMaker> findDiscussesToAutoMaker(AutoMakerDetail autoMakerDetail) {
		return this.getEntityManager()
    			.createQuery("from DiscussToAutoMaker as obj where obj.autoMakerDetail=:amd")
    			.setParameter("amd", autoMakerDetail).getResultList();
	}

    

}
