package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.GarageDetail;


@Repository
public class DiscussToGarageDaoImpl extends AbstractJpaDAO<DiscussToGarage> implements DiscussToGarageDao {

    public DiscussToGarageDaoImpl() {
        super();
        
        setClazz(DiscussToGarage.class);
    }

    // API
	@SuppressWarnings("unchecked")
	public List<DiscussToGarage> findDiscussesToGarage(GarageDetail garageDetail) {
		return this.getEntityManager()
    			.createQuery("from DiscussToGarage as obj where obj.garageDetail=:gd")
    			.setParameter("gd", garageDetail).getResultList();
	}

    

}
