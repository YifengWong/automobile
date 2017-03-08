package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.FavorablesSmallClassesMiddle;
import automobile.business.entities.SmallClass;

public interface FavorablesSmallClassesMiddleDao {
	
	FavorablesSmallClassesMiddle findOne(String id);

    List<FavorablesSmallClassesMiddle> findAll();

    void create(FavorablesSmallClassesMiddle entity);

    FavorablesSmallClassesMiddle update(FavorablesSmallClassesMiddle entity);

    void delete(FavorablesSmallClassesMiddle entity);

    void deleteById(String entityId);
    
	public List<FavorablesSmallClassesMiddle> findBySmallClass(final SmallClass smallClass);

}
