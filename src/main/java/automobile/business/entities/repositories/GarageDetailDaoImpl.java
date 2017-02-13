package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.GarageDetail;

@Repository
public class GarageDetailDaoImpl extends AbstractJpaDAO<GarageDetail> implements GarageDetailDao {

    public GarageDetailDaoImpl() {
        super();

        setClazz(GarageDetail.class);
    }

    // API
	public GarageDetail findOne(String username) {
		return (GarageDetail) this.getEntityManager()
    			.createQuery("from GarageDetail as obj where obj.username=:un")
    			.setParameter("un", username).getSingleResult();
	}

}
