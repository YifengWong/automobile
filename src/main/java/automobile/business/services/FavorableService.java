package automobile.business.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.Favorable;
import automobile.business.entities.FavorablesSmallClassesMiddle;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.FavorableDao;
import automobile.business.entities.repositories.FavorablesSmallClassesMiddleDao;

/**
 * @author CrazeWong
 * 优惠信息相关服务类
 */
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
    
    
    /**
     * @param favorable
     * @param classes
     * 根据分类新建一条优惠信息
     */
    public void createFavorable(final Favorable favorable, final Set<SmallClass> classes) {
    	favorableDao.create(favorable);
    	for (SmallClass sc : classes) {
    		favorablesSmallClassesMiddleDao.create(new FavorablesSmallClassesMiddle(sc, favorable));
    	}
    }
    
    /**
     * @return
     * 获取所有优惠信息
     */
    public List<Favorable> findAllFavorable() {
    	return favorableDao.findAll();
    }

}
