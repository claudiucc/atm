package com.infoworld.service;

import com.infoworld.model.Atm;
import com.infoworld.repository.AtmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Claudiu on 21.06.2018.
 */
@Service
public class AtmService {

    @Autowired
    AtmDAO atmDAO;

    public Atm findById(Integer id) {
        return atmDAO.findById(id);
    }

    public Atm update(Atm atm) {
        return atmDAO.update(atm);
    }
}
