package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.Favorable;
import automobile.business.entities.repositories.FavorableDao;

@Service
@Transactional
public class FavorableService {

    @Autowired
    private FavorableDao dao;

    public FavorableService() {
        super();
    }

    // API
    public void create(final Favorable entity) {
        dao.create(entity);
    }

    public Favorable findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<Favorable> findAll() {
        return dao.findAll();
    }

}
