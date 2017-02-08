package automobile.business.entities.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.MsgToAutoMaker;


@Repository
public class MsgToAutoMakerDaoImpl extends AbstractJpaDAO<MsgToAutoMaker> implements MsgToAutoMakerDao {

    public MsgToAutoMakerDaoImpl() {
        super();
        
        setClazz(MsgToAutoMaker.class);
    }

    // API
	@SuppressWarnings("unchecked")
	public List<MsgToAutoMaker> findMsgsToAutoMaker(AutoMakerDetail autoMakerDetail) {
		return this.getEntityManager()
    			.createQuery("from MsgToAutoMaker as obj where obj.autoMakerDetail=:amd")
    			.setParameter("amd", autoMakerDetail).getResultList();
	}


}
