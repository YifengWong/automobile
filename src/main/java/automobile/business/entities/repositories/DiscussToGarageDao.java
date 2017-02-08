package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.GarageDetail;

public interface DiscussToGarageDao {
	DiscussToGarage findOne(Integer id);

    List<DiscussToGarage> findAll();

    void create(DiscussToGarage entity);

    DiscussToGarage update(DiscussToGarage entity);

    void delete(DiscussToGarage entity);

    void deleteById(Integer entityId);
    
    // API
    List<DiscussToGarage> findDiscussesToGarage(GarageDetail garageDetail);

}
