package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.BigClass;

public interface BigClassDao {

	BigClass findOne(Integer id);

    List<BigClass> findAll();

    void create(BigClass entity);

    BigClass update(BigClass entity);

    void delete(BigClass entity);

    void deleteById(Integer entityId);
    
    // API
    BigClass findOne(String name);
}
