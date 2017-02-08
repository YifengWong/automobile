package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.MsgToAutoMaker;

public interface MsgToAutoMakerDao {
	
	MsgToAutoMaker findOne(Integer id);

    List<MsgToAutoMaker> findAll();

    void create(MsgToAutoMaker entity);

    MsgToAutoMaker update(MsgToAutoMaker entity);

    void delete(MsgToAutoMaker entity);

    void deleteById(Integer entityId);
    
    // API
    List<MsgToAutoMaker> findMsgsToAutoMaker(AutoMakerDetail autoMakerDetail);

}
