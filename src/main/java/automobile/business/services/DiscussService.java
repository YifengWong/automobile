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
	public void createDiscussToAutoMaker(final DiscussToAutoMaker discussToAutoMaker) {
		discussToAutoMakerDao.create(discussToAutoMaker);
	}
	
	public void createDiscussToGarage(final DiscussToGarage discussToGarage) {
		discussToGarageDao.create(discussToGarage);
	}
	
	public List<DiscussToGarage> findAllDiscussToGarage(final GarageDetail garageDetail) {
		return discussToGarageDao.findDiscussesToGarage(garageDetail);
	}
	
	public List<DiscussToAutoMaker> findAllDisscussToAutoMaker(final AutoMakerDetail autoMakerDetail) {
		return discussToAutoMakerDao.findDiscussesToAutoMaker(autoMakerDetail);
	}

}
