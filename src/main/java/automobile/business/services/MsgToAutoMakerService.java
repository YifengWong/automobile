package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.MsgToAutoMaker;
import automobile.business.entities.repositories.MsgToAutoMakerDao;

@Service
@Transactional
public class MsgToAutoMakerService {

    @Autowired
    private MsgToAutoMakerDao dao;

    public MsgToAutoMakerService() {
        super();
    }

    // API
    public void create(final MsgToAutoMaker entity) {
        dao.create(entity);
    }

    public MsgToAutoMaker findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<MsgToAutoMaker> findAll() {
        return dao.findAll();
    }

}
