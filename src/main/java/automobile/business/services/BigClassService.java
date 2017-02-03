package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.BigClass;
import automobile.business.entities.repositories.BigClassDao;

@Service
@Transactional
public class BigClassService {

    @Autowired
    private BigClassDao dao;

    public BigClassService() {
        super();
    }

    // API
    public void create(final BigClass entity) {
        dao.create(entity);
    }

    public BigClass findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<BigClass> findAll() {
        return dao.findAll();
    }

}
