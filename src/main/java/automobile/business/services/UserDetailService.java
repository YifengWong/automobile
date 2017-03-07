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
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

/**
 * @author CrazeWong
 * 用户相关服务类
 */
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
	
	
    /**
     * @param autoMakerDetail
     * @param classes
     * 根据分类创建汽配商用户
     */
    public void createAutoMakerDetail(final AutoMakerDetail autoMakerDetail, final Set<SmallClass> classes) {
    	autoMakerDetailDao.create(autoMakerDetail);
    	if (classes == null) return;
    	for (SmallClass sc : classes) {
    		autosSmallClassesMiddleDao.create(new AutosSmallClassesMiddle(sc, autoMakerDetail));
    	}
    	
    }
    
    public void addAutoMakerDetailClass(final AutoMakerDetail autoMakerDetail, SmallClass sc) {
    	if (sc == null) return;
    	if (autoMakerDetail == null) return;
    	autosSmallClassesMiddleDao.create(new AutosSmallClassesMiddle(sc, autoMakerDetail));
    }
    
    /**
     * @param id
     * @return
     * 根据id获取汽配商用户信息
     */
    public AutoMakerDetail findAutoMakerDetailById(final String id) {
    	return autoMakerDetailDao.findOne(id);
    }
    
    /**
     * @param garageDetail
     * 创建汽修厂用户
     */
    public void createGarageDetail(final GarageDetail garageDetail) {
    	garageDetailDao.create(garageDetail);
    }
    
    /**
     * @param id
     * @return
     * 根据id获取汽修厂用户信息
     */
    public GarageDetail findGarageDetailById(final String id) {
    	return garageDetailDao.findOne(id);
    }
    
    /**
     * @param username
     * @return
     * 根据用户名（应该为手机号）获取汽配商用户
     */
    public AutoMakerDetail findAutoMakerDetailByUserName(final String username) {
    	return autoMakerDetailDao.findOneByUserName(username);
    }
    
    /**
     * @param username
     * @return
     * 根据用户名（应该为手机号）获取汽修厂用户
     */
    public GarageDetail findGarageDetailByUserName(final String username) {
    	return garageDetailDao.findOneByUserName(username);
    }
    
    /**
     * @param smallClass
     * @return
     * 获取某一分类下的所有汽配商
     */
    public List<AutoMakerDetail> findAllAutoMakerDetailBySmallClass(SmallClass smallClass) {
    	List<AutosSmallClassesMiddle> middles = autosSmallClassesMiddleDao.findBySmallClass(smallClass);
    	List<AutoMakerDetail> autos = new ArrayList<AutoMakerDetail>();
    	for (AutosSmallClassesMiddle m : middles) {
    		autos.add(m.getAutoMakerDetail());
    	}
    	return autos;
    }
    
    /**
     * @param username
     * @param password
     * @return
     * 检查汽配商用户登入信息
     */
    public ResultObject checkAutoMakerDetail(String username, String password) {
    	
    	AutoMakerDetail user = findAutoMakerDetailByUserName(username);
    	if (user == null) {
			return new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_USERNAME, null);
		} else {
			if (!user.getPassword().equals(password)) {
				return new ResultObject(
						StaticString.RESULT_FAIL, StaticString.USER_WRONG_PASSWORD, null);
			} else {
				return new ResultObject(
						StaticString.RESULT_SUCC, StaticString.USER_LOGIN_SUCC, user);
			}
		}
    }
    
    /**
     * @param username
     * @param password
     * @return
     * 检查汽修厂用户登入信息
     */
    public ResultObject checkGarageDetail(String username, String password) {
    	
    	GarageDetail user = findGarageDetailByUserName(username);
    	if (user == null) {
			return new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_USERNAME, null);
		} else {
			if (!user.getPassword().equals(password)) {
				return new ResultObject(
						StaticString.RESULT_FAIL, StaticString.USER_WRONG_PASSWORD, null);
			} else {
				return new ResultObject(
						StaticString.RESULT_SUCC, StaticString.USER_LOGIN_SUCC, user);
			}
		}
    }
    
    /**
     * @param user
     * 更新汽配商用户信息
     */
    public void updateAutoMakerDetail(AutoMakerDetail user) {
    	autoMakerDetailDao.update((AutoMakerDetail) user);
    }
    
    /**
     * @param user
     * 更新汽修厂用户信息
     */
    public void updateGarageDetail(GarageDetail user) {
    	garageDetailDao.update((GarageDetail) user);
    }

    
}
