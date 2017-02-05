package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.repositories.DiscussToGarageDao;

@Service
@Transactional
public class DiscussToGarageService {

    @Autowired
    private DiscussToGarageDao dao;

    public DiscussToGarageService() {
        super();
    }

    // API
    public void create(final DiscussToGarage entity) {
        dao.create(entity);
    }

    public DiscussToGarage findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<DiscussToGarage> findAll() {
        return dao.findAll();
    }

}
