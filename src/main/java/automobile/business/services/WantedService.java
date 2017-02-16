package automobile.business.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.SmallClass;
import automobile.business.entities.Wanted;
import automobile.business.entities.WantedsSmallClassesMiddle;
import automobile.business.entities.repositories.WantedDao;
import automobile.business.entities.repositories.WantedsSmallClassesMiddleDao;

@Service
@Transactional
public class WantedService {

	@Autowired
    private WantedDao wantedDao;
	
	@Autowired
	private WantedsSmallClassesMiddleDao wantedsSmallClassesMiddleDao;

    public WantedService() {
        super();
    }

    // API
    public void createWanted(final Wanted wanted, final Set<SmallClass> classes) {
    	wantedDao.create(wanted);
    	for (SmallClass sc : classes) {
    		wantedsSmallClassesMiddleDao.create(new WantedsSmallClassesMiddle(sc, wanted));
    	}
    }
    
    public List<Wanted> findAllWanted() {
    	return wantedDao.findAll();
    }

}
