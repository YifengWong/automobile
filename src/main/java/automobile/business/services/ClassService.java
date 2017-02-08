package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.BigClassDao;
import automobile.business.entities.repositories.SmallClassDao;

@Service
@Transactional
public class ClassService {
	
	@Autowired
	private BigClassDao bigClassDao;
	
	@Autowired
	private SmallClassDao smallClassDao;
	
	
	public ClassService() {
		super();
	}
	
	public void createBigClass(final BigClass bigClass) {
		bigClassDao.create(bigClass);
	}
	
	public void createSmallClass(final SmallClass smallClass) {
		smallClassDao.create(smallClass);
	}
	
	public List<BigClass> findAllBigClasses() {
		return bigClassDao.findAll();
	}
	
	public List<SmallClass> findAllSmallClassesFrom(final BigClass bigClass) {
		return smallClassDao.findAllByBigClass(bigClass);
	}

}
