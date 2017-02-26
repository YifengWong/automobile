package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutoMakerDetail;

public interface AutoMakerDetailDao {

	AutoMakerDetail findOne(String id);

    List<AutoMakerDetail> findAll();

    void create(AutoMakerDetail entity);

    AutoMakerDetail update(AutoMakerDetail entity);

    void delete(AutoMakerDetail entity);

    void deleteById(String entityId);
    
    // API
    AutoMakerDetail findOneByUserName(String username);

}