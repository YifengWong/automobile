package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.Wanted;
import automobile.business.entities.repositories.WantedDao;

@Service
@Transactional
public class WantedService {

    @Autowired
    private WantedDao dao;

    public WantedService() {
        super();
    }

    // API
    public void create(final Wanted entity) {
        dao.create(entity);
    }

    public Wanted findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<Wanted> findAll() {
        return dao.findAll();
    }

}
