package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.DiscussToAutoMaker;

public interface DiscussToAutoMakerDao {
	DiscussToAutoMaker findOne(Integer id);

    List<DiscussToAutoMaker> findAll();

    void create(DiscussToAutoMaker entity);

    DiscussToAutoMaker update(DiscussToAutoMaker entity);

    void delete(DiscussToAutoMaker entity);

    void deleteById(Integer entityId);
    
    // API
    List<DiscussToAutoMaker> findDiscussesToAutoMaker(AutoMakerDetail autoMakerDetail);

}
