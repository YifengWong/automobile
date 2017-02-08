package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.SmallClassDao;

public class SmallClassService {

    private SmallClassDao dao;

    public SmallClassService() {
        super();
    }

    // API
    public void create(final SmallClass entity) {
        dao.create(entity);
    }

    public SmallClass findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<SmallClass> findAll() {
        return dao.findAll();
    }
    
    public List<SmallClass> findByBigClass(final BigClass bigClass) {
    	return dao.findByBigClass(bigClass);
    }

}
