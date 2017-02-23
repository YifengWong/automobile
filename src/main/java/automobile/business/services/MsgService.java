package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToAutoMaker;
import automobile.business.entities.MsgToGarage;
import automobile.business.entities.repositories.MsgToAutoMakerDao;
import automobile.business.entities.repositories.MsgToGarageDao;

/**
 * @author CrazeWong
 * 消息相关服务类
 */
@Service
@Transactional
public class MsgService {
	
	@Autowired
	private MsgToAutoMakerDao msgToAutoMakerDao;
	
	@Autowired
	private MsgToGarageDao msgToGarageDao;
	
	public MsgService() {
		super();
	}
	
	/**
	 * @param msgToAutoMaker
	 * 新建一条发送给汽配商的消息
	 */
	public void createMsgToAutoMaker(final MsgToAutoMaker msgToAutoMaker) {
		msgToAutoMakerDao.create(msgToAutoMaker);
	}
	
	/**
	 * @param msgToGarage
	 * 新建一条发送给汽修厂的消息
	 */
	public void createMsgToGarage(final MsgToGarage msgToGarage) {
		msgToGarageDao.create(msgToGarage);
	}
	
	/**
	 * @param autoMakerDetail
	 * @return
	 * 获取发送给该汽配商 的所有消息
	 */
	public List<MsgToAutoMaker> findAllMsgsToAutoMaker(final AutoMakerDetail autoMakerDetail) {
		return msgToAutoMakerDao.findMsgsToAutoMaker(autoMakerDetail);
	}
	
	/**
	 * @param garageDetail
	 * @return
	 * 获取发送给该汽修厂的所有消息
	 */
	public List<MsgToGarage> findAllMsgsToGarage(final GarageDetail garageDetail) {
		return msgToGarageDao.findMsgsToGarage(garageDetail);
	}

}
