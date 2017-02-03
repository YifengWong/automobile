package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.AutosSmallClassesMiddleDao;

@Service
@Transactional
public class AutosSmallClassesMiddleService {

    @Autowired
    private AutosSmallClassesMiddleDao dao;

    public AutosSmallClassesMiddleService() {
        super();
    }

    // API
    public void create(final AutosSmallClassesMiddle entity) {
        dao.create(entity);
    }

    public AutosSmallClassesMiddle findById(final Integer id) {
        return dao.findOne(id);
    }

    public List<AutosSmallClassesMiddle> findAll() {
        return dao.findAll();
    }
    
	public List<AutosSmallClassesMiddle> findBySmallClass(final SmallClass smallClass) {
    	return dao.findBySmallClass(smallClass);

    }
    
	public List<AutosSmallClassesMiddle> findByAutoMakerDetail(final AutoMakerDetail autoMakerDetail) {
    	return dao.findByAutoMakerDetail(autoMakerDetail);

    }

}
