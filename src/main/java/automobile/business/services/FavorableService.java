package automobile.business.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.Favorable;
import automobile.business.entities.FavorablesSmallClassesMiddle;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.FavorableDao;
import automobile.business.entities.repositories.FavorablesSmallClassesMiddleDao;

@Service
@Transactional
public class FavorableService {

	@Autowired
    private FavorableDao favorableDao;
    
	@Autowired
    private FavorablesSmallClassesMiddleDao favorablesSmallClassesMiddleDao;

    public FavorableService() {
        super();
    }

    // API
    public void createFavorable(final Favorable favorable, final Set<SmallClass> classes) {
    	favorableDao.create(favorable);
    	for (SmallClass sc : classes) {
    		favorablesSmallClassesMiddleDao.create(new FavorablesSmallClassesMiddle(sc, favorable));
    	}
    }

}
