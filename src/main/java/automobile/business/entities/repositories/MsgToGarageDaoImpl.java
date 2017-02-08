package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToGarage;

@Repository
public class MsgToGarageDaoImpl extends AbstractJpaDAO<MsgToGarage> implements MsgToGarageDao {

    public MsgToGarageDaoImpl() {
        super();

        setClazz(MsgToGarage.class);
    }

    
    // API
	@SuppressWarnings("unchecked")
	public List<MsgToGarage> findMsgsToGarage(GarageDetail garageDetail) {
		return this.getEntityManager()
    			.createQuery("from MsgToGarage as obj where obj.garageDetail=:gd")
    			.setParameter("gd", garageDetail).getResultList();
	}

    

}
