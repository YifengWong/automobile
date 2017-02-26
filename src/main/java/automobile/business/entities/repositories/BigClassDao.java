package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.BigClass;

public interface BigClassDao {

	BigClass findOne(String id);

    List<BigClass> findAll();

    void create(BigClass entity);

    BigClass update(BigClass entity);

    void delete(BigClass entity);

    void deleteById(String entityId);
    
    // API
    BigClass findOneByName(String name);
}
