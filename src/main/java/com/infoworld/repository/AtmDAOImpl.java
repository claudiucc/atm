package com.infoworld.repository;

import com.infoworld.model.Atm;
import org.springframework.stereotype.Repository;

/**
 * Created by Claudiu on 06.07.2018.
 */
@Repository("AtmDAO")
public class AtmDAOImpl extends AbstractDAOImpl<Atm> implements AtmDAO {

    public Class<Atm> getGenericClass() {
        return Atm.class;
    }

}
