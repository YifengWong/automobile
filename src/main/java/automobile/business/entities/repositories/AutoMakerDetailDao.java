package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutoMakerDetail;

public interface AutoMakerDetailDao {

	AutoMakerDetail findOne(Integer id);

    List<AutoMakerDetail> findAll();

    void create(AutoMakerDetail entity);

    AutoMakerDetail update(AutoMakerDetail entity);

    void delete(AutoMakerDetail entity);

    void deleteById(Integer entityId);
    
    // API
    AutoMakerDetail findOne(String username);

}