package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToGarage;

public interface MsgToGarageDao {

	MsgToGarage findOne(String id);

    List<MsgToGarage> findAll();

    void create(MsgToGarage entity);

    MsgToGarage update(MsgToGarage entity);

    void delete(MsgToGarage entity);

    void deleteById(String entityId);
    
    // API
    List<MsgToGarage> findMsgsToGarage(GarageDetail garageDetail);

}