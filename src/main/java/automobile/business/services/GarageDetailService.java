package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.GarageDetail;
import automobile.business.entities.repositories.GarageDetailDao;

@Service
@Transactional
public class GarageDetailService {

    @Autowired
    private GarageDetailDao dao;

    public GarageDetailService() {
        super();
    }

    // API
    public void create(final GarageDetail entity) {
        dao.create(entity);
    }

    public GarageDetail findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<GarageDetail> findAll() {
        return dao.findAll();
    }

}
