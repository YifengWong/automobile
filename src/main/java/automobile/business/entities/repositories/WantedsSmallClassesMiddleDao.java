package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.SmallClass;
import automobile.business.entities.WantedsSmallClassesMiddle;

public interface WantedsSmallClassesMiddleDao {
	
	WantedsSmallClassesMiddle findOne(String id);

    List<WantedsSmallClassesMiddle> findAll();

    void create(WantedsSmallClassesMiddle entity);

    WantedsSmallClassesMiddle update(WantedsSmallClassesMiddle entity);

    void delete(WantedsSmallClassesMiddle entity);

    void deleteById(String entityId);
    
	public List<WantedsSmallClassesMiddle> findBySmallClass(final SmallClass smallClass);

}
