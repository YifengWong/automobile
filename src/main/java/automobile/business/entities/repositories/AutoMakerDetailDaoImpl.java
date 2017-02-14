package automobile.business.entities.repositories;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import automobile.business.entities.AutoMakerDetail;

@Repository
public class AutoMakerDetailDaoImpl extends AbstractJpaDAO<AutoMakerDetail> implements AutoMakerDetailDao {

    public AutoMakerDetailDaoImpl() {
        super();
        
        setClazz(AutoMakerDetail.class);
    }

    // API
	public AutoMakerDetail findOne(String username) {
		AutoMakerDetail auto = null;
		try {
			auto = (AutoMakerDetail) this.getEntityManager()
	    			.createQuery("from AutoMakerDetail as obj where obj.username=:un")
	    			.setParameter("un", username).getSingleResult();
		} catch (NoResultException e) {
			auto = null;
		}
		
		return auto;
	}
}
