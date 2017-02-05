package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.DiscussToAutoMaker;
import automobile.business.entities.repositories.DiscussToAutoMakerDao;

@Service
@Transactional
public class DiscussToAutoMakerService {

    @Autowired
    private DiscussToAutoMakerDao dao;

    public DiscussToAutoMakerService() {
        super();
    }

    // API
    public void create(final DiscussToAutoMaker entity) {
        dao.create(entity);
    }

    public DiscussToAutoMaker findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<DiscussToAutoMaker> findAll() {
        return dao.findAll();
    }

}
