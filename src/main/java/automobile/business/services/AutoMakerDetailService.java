package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.repositories.AutoMakerDetailDao;

@Service
@Transactional
public class AutoMakerDetailService {

    @Autowired
    private AutoMakerDetailDao dao;

    public AutoMakerDetailService() {
        super();
    }

    // API
    public void create(final AutoMakerDetail entity) {
        dao.create(entity);
    }

    public AutoMakerDetail findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<AutoMakerDetail> findAll() {
        return dao.findAll();
    }

}
