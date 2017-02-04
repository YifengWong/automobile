package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.MsgToGarage;

@Repository
public class MsgToGarageDaoImpl extends AbstractJpaDAO<MsgToGarage> implements MsgToGarageDao {

    public MsgToGarageDaoImpl() {
        super();

        setClazz(MsgToGarage.class);
    }

    // API

}
