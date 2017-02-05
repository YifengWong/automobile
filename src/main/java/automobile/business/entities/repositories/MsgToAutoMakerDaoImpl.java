package automobile.business.entities.repositories;

import org.springframework.stereotype.Repository;

import automobile.business.entities.MsgToAutoMaker;


@Repository
public class MsgToAutoMakerDaoImpl extends AbstractJpaDAO<MsgToAutoMaker> implements MsgToAutoMakerDao {

    public MsgToAutoMakerDaoImpl() {
        super();
        
        setClazz(MsgToAutoMaker.class);
    }

    // API

}
