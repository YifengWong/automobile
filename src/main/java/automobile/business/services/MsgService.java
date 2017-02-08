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
	
	public void createMsgToAutoMaker(final MsgToAutoMaker msgToAutoMaker) {
		msgToAutoMakerDao.create(msgToAutoMaker);
	}
	
	public void createMsgToGarage(final MsgToGarage msgToGarage) {
		msgToGarageDao.create(msgToGarage);
	}
	
	public List<MsgToAutoMaker> findAllMsgsToAutoMaker(final AutoMakerDetail autoMakerDetail) {
		return msgToAutoMakerDao.findMsgsToAutoMaker(autoMakerDetail);
	}
	
	public List<MsgToGarage> findAllMsgsToGarage(final GarageDetail garageDetail) {
		return msgToGarageDao.findMsgsToGarage(garageDetail);
	}

}
