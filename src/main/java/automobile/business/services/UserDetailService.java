package automobile.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.AutoMakerDetailDao;
import automobile.business.entities.repositories.AutosSmallClassesMiddleDao;
import automobile.business.entities.repositories.GarageDetailDao;

@Service
@Transactional
public class UserDetailService {
	
	@Autowired
    private AutoMakerDetailDao autoMakerDetailDao;
    
    @Autowired
    private AutosSmallClassesMiddleDao autosSmallClassesMiddleDao;
    
    @Autowired
    private GarageDetailDao garageDetailDao;

	public UserDetailService() {
		super();
	}
    
	// API
    public void createAutoMakerDetail(final AutoMakerDetail autoMakerDetail, final Set<SmallClass> classes) {
    	autoMakerDetailDao.create(autoMakerDetail);
    	for (SmallClass sc : classes) {
    		autosSmallClassesMiddleDao.create(new AutosSmallClassesMiddle(sc, autoMakerDetail));
    	}
    	
    }
    
    public AutoMakerDetail findAutoMakerDetailById(final Integer id) {
    	return autoMakerDetailDao.findOne(id);
    }
    
    public void createGarageDetail(final GarageDetail garageDetail) {
    	garageDetailDao.create(garageDetail);
    }
    
    public GarageDetail findGarageDetailById(final Integer id) {
    	return garageDetailDao.findOne(id);
    }
    
    public AutoMakerDetail findAutoMakerDetailByUserName(final String username) {
    	return autoMakerDetailDao.findOne(username);
    }
    
    public GarageDetail findGarageDetailByUserName(final String username) {
    	return garageDetailDao.findOne(username);
    }
    
    public List<AutoMakerDetail> findAllAutoMakerDetailBySmallClass(SmallClass smallClass) {
    	List<AutosSmallClassesMiddle> middles = autosSmallClassesMiddleDao.findBySmallClass(smallClass);
    	List<AutoMakerDetail> autos = new ArrayList<AutoMakerDetail>();
    	for (AutosSmallClassesMiddle m : middles) {
    		autos.add(m.getAutoMakerDetail());
    	}
    	return autos;
    }

    
}
