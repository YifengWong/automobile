package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.Wanted;

public interface WantedDao {
	
	Wanted findOne(String id);

    List<Wanted> findAll();

    void create(Wanted entity);

    Wanted update(Wanted entity);

    void delete(Wanted entity);

    void deleteById(String entityId);

}
