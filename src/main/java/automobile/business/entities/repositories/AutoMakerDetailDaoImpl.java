package automobile.business.entities.repositories;

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
		return (AutoMakerDetail) this.getEntityManager()
    			.createQuery("from AutoMakerDetail as obj where obj.username=:un")
    			.setParameter("un", username).getSingleResult();
	}
}
