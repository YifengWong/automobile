package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.SmallClass;

public interface AutosSmallClassesMiddleDao {

	AutosSmallClassesMiddle findOne(String id);

    List<AutosSmallClassesMiddle> findAll();

    void create(AutosSmallClassesMiddle entity);

    AutosSmallClassesMiddle update(AutosSmallClassesMiddle entity);

    void delete(AutosSmallClassesMiddle entity);

    void deleteById(String entityId);
    
    // API
	public List<AutosSmallClassesMiddle> findBySmallClass(final SmallClass smallClass);
    
	public List<AutosSmallClassesMiddle> findByAutoMakerDetail(final AutoMakerDetail autoMakerDetail);

}