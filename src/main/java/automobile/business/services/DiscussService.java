package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.DiscussToAutoMaker;
import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.repositories.DiscussToAutoMakerDao;
import automobile.business.entities.repositories.DiscussToGarageDao;

/**
 * @author CrazeWong
 * 评论相关服务类
 */
@Service
@Transactional
public class DiscussService {
	
	@Autowired
    private DiscussToAutoMakerDao discussToAutoMakerDao;
	
	@Autowired
    private DiscussToGarageDao discussToGarageDao;
	
	public DiscussService() {
		super();
	}
	
	// API
	
	/**
	 * @param discussToAutoMaker
	 * 新建一条对汽配商的评论
	 */
	public void createDiscussToAutoMaker(final DiscussToAutoMaker discussToAutoMaker) {
		discussToAutoMakerDao.create(discussToAutoMaker);
	}
	
	/**
	 * @param discussToGarage
	 * 新建一条对汽修厂的评论
	 */
	public void createDiscussToGarage(final DiscussToGarage discussToGarage) {
		discussToGarageDao.create(discussToGarage);
	}
	
	/**
	 * @param garageDetail
	 * @return
	 * 获取该汽修厂的所有评论
	 */
	public List<DiscussToGarage> findAllDiscussToGarage(final GarageDetail garageDetail) {
		return discussToGarageDao.findDiscussesToGarage(garageDetail);
	}
	
	/**
	 * @param autoMakerDetail
	 * @return
	 * 获取该汽配商的所有评论
	 */
	public List<DiscussToAutoMaker> findAllDiscussToAutoMaker(final AutoMakerDetail autoMakerDetail) {
		return discussToAutoMakerDao.findDiscussesToAutoMaker(autoMakerDetail);
	}

}
