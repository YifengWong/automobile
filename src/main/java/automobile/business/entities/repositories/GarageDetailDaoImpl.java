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

}
