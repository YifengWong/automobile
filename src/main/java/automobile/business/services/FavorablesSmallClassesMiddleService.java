package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.FavorablesSmallClassesMiddle;
import automobile.business.entities.repositories.FavorablesSmallClassesMiddleDao;

public class FavorablesSmallClassesMiddleService {

    private FavorablesSmallClassesMiddleDao dao;

    public FavorablesSmallClassesMiddleService() {
        super();
    }

    // API
    public void create(final FavorablesSmallClassesMiddle entity) {
        dao.create(entity);
    }

    public FavorablesSmallClassesMiddle findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<FavorablesSmallClassesMiddle> findAll() {
        return dao.findAll();
    }

}
