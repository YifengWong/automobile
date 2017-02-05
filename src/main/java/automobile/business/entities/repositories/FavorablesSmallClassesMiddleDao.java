package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.FavorablesSmallClassesMiddle;

public interface FavorablesSmallClassesMiddleDao {
	
	FavorablesSmallClassesMiddle findOne(Integer id);

    List<FavorablesSmallClassesMiddle> findAll();

    void create(FavorablesSmallClassesMiddle entity);

    FavorablesSmallClassesMiddle update(FavorablesSmallClassesMiddle entity);

    void delete(FavorablesSmallClassesMiddle entity);

    void deleteById(Integer entityId);

}
