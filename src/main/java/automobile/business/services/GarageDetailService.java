package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.GarageDetail;
import automobile.business.entities.repositories.GarageDetailDao;


public class GarageDetailService {

    private GarageDetailDao garageDetailDao;

    public GarageDetailService() {
        super();
    }

    // API
    public void createGarageDetail(final GarageDetail garageDetail) {
    	garageDetailDao.create(garageDetail);
    }
    
    public GarageDetail findGarageDetailById(final Integer id) {
    	return garageDetailDao.findOne(id);
    }

}
