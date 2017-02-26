package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.Favorable;

public interface FavorableDao {
	Favorable findOne(String id);

    List<Favorable> findAll();

    void create(Favorable entity);

    Favorable update(Favorable entity);

    void delete(Favorable entity);

    void deleteById(String entityId);

}
