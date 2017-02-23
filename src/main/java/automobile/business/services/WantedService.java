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

/**
 * @author CrazeWong
 * 求购信息相关服务类
 */
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
    
    
    /**
     * @param wanted
     * @param classes
     * 根据分类创建求购信息
     */
    public void createWanted(final Wanted wanted, final Set<SmallClass> classes) {
    	wantedDao.create(wanted);
    	for (SmallClass sc : classes) {
    		wantedsSmallClassesMiddleDao.create(new WantedsSmallClassesMiddle(sc, wanted));
    	}
    }
    
    /**
     * @return
     * 获取所有求购信息
     */
    public List<Wanted> findAllWanted() {
    	return wantedDao.findAll();
    }

}
