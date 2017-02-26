package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;

public interface SmallClassDao {

	SmallClass findOne(String id);

    List<SmallClass> findAll();

    void create(SmallClass entity);

    SmallClass update(SmallClass entity);

    void delete(SmallClass entity);

    void deleteById(String entityId);
    
    // API
    public List<SmallClass> findAllByBigClass(final BigClass bigClass);
    
    SmallClass findOneByName(String name);

}