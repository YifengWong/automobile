package automobile.business.entities.repositories;

import java.util.List;

import automobile.business.entities.GarageDetail;

public interface GarageDetailDao {

	GarageDetail findOne(Integer id);

    List<GarageDetail> findAll();

    void create(GarageDetail entity);

    GarageDetail update(GarageDetail entity);

    void delete(GarageDetail entity);

    void deleteById(Integer entityId);

}
