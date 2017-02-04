package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.MsgToGarage;
import automobile.business.entities.repositories.MsgToGarageDao;

@Service
@Transactional
public class MsgToGarageService {

    @Autowired
    private MsgToGarageDao dao;

    public MsgToGarageService() {
        super();
    }

    // API
    public void create(final MsgToGarage entity) {
        dao.create(entity);
    }

    public MsgToGarage findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<MsgToGarage> findAll() {
        return dao.findAll();
    }

}
