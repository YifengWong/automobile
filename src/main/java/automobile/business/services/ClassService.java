package automobile.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;
import automobile.business.entities.repositories.BigClassDao;
import automobile.business.entities.repositories.SmallClassDao;

/**
 * @author CrazeWong
 * 分类相关服务类
 */
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
	
	/**
	 * @param bigClass
	 * 新建大分类
	 */
	public void createBigClass(final BigClass bigClass) {
		bigClassDao.create(bigClass);
	}
	
	/**
	 * @param smallClass
	 * 新建小分类
	 */
	public void createSmallClass(final SmallClass smallClass) {
		smallClassDao.create(smallClass);
	}
	
	/**
	 * @return
	 * 获取所有分类信息
	 */
	public List<BigClass> findAllBigClasses() {
		return bigClassDao.findAll();
	}
	
	/**
	 * @param bigClass
	 * @return
	 * 获取某一大分类下的所有小分类
	 */
	public List<SmallClass> findAllSmallClassesFrom(final BigClass bigClass) {
		return smallClassDao.findAllByBigClass(bigClass);
	}
	
	/**
	 * @param id
	 * @return
	 * 根据id获取大分类
	 */
	public BigClass findBigClassById(Integer id) {
		return bigClassDao.findOne(id);
	}
	
	/**
	 * @param name
	 * @return
	 * 根据名字获取大分类
	 */
	public BigClass findBigClassByName(String name) {
		return bigClassDao.findOne(name);
	}
	
	/**
	 * @param id
	 * @return
	 * 根据id获取小分类
	 */
	public SmallClass findSmallClasById(Integer id) {
		return smallClassDao.findOne(id);
	}
	
	/**
	 * @param name
	 * @return
	 * 根据名字获取小分类
	 */
	public SmallClass findSmallClassByName(String name) {
		return smallClassDao.findOne(name);
	}

}
