package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.WantedsSmallClassesMiddle;

public interface WantedsSmallClassesMiddleDao {
	
	WantedsSmallClassesMiddle findOne(Integer id);

    List<WantedsSmallClassesMiddle> findAll();

    void create(WantedsSmallClassesMiddle entity);

    WantedsSmallClassesMiddle update(WantedsSmallClassesMiddle entity);

    void delete(WantedsSmallClassesMiddle entity);

    void deleteById(Integer entityId);

}
