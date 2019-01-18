package com.infoworld.controller;

import com.infoworld.model.Amount;
import com.infoworld.model.Atm;
import com.infoworld.service.AtmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Claudiu on 01/17/2018.
 */
@Controller
public class AtmController {

    private final Logger logger = LoggerFactory.getLogger(AtmController.class);

    @Autowired
    AtmService atmService;

    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public ResponseEntity<Object> getAmount(@RequestParam("amount") Integer amount) {
        Atm atm = atmService.findById(1);
        Amount sum = new Amount();

        if(atm.getBanknote100() < 20) {
            logger.warn("Numarul bancnotelor de 100 de lei a scazut sub 20!");
            System.out.println("Warning! Numarul bancnotelor de 100 de lei a scazut sub 20!");
        }

        if(atm.getBanknote100() < 5) {
            logger.warn("Numarul bancnotelor de 100 de lei a scazut sub 10%!");
            System.out.println("Critical! Numarul bancnotelor de 100 de lei a scazut sub 10%!");
        }

        if(atm.getBanknote50() < 7.5) {
            logger.warn("Numarul bancnotelor de 50 de lei a scazut sub 15%!");
            System.out.println("Warning! Numarul bancnotelor de 50 de lei a scazut sub 15%!");
        }

        int[] notes = new int[]{100, 50, 10, 5, 1};
        int[] noteCounter = new int[5];

        for (int i = 0; i < 5; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount - noteCounter[i] * notes[i];
            }
        }

        if (noteCounter[0] <= atm.getBanknote100())
            sum.setBanknote100(noteCounter[0]);
        else
            return new ResponseEntity<Object>("Tranzactie esuata! Bancomatul nu are disponibila aceasta suma.", HttpStatus.BAD_REQUEST);

        if (noteCounter[1] <= atm.getBanknote50())
            sum.setBanknote50(noteCounter[1]);
        else
            return new ResponseEntity<Object>("Tranzactie esuata! Bancomatul nu are disponibila aceasta suma.", HttpStatus.BAD_REQUEST);

        if (noteCounter[2] <= atm.getBanknote10())
            sum.setBanknote10(noteCounter[2]);
        else
            return new ResponseEntity<Object>("Tranzactie esuata! Bancomatul nu are disponibila aceasta suma.", HttpStatus.BAD_REQUEST);

        if (noteCounter[3] <= atm.getBanknote5())
            sum.setBanknote5(noteCounter[3]);
        else
            return new ResponseEntity<Object>("Tranzactie esuata! Bancomatul nu are disponibila aceasta suma.", HttpStatus.BAD_REQUEST);

        if (noteCounter[4] <= atm.getBanknote1())
            sum.setBanknote1(noteCounter[4]);
        else
            return new ResponseEntity<Object>("Tranzactie esuata! Bancomatul nu are disponibila aceasta suma.", HttpStatus.BAD_REQUEST);

        atm.setBanknote1(atm.getBanknote1() - noteCounter[4]);
        atm.setBanknote5(atm.getBanknote5() - noteCounter[3]);
        atm.setBanknote10(atm.getBanknote10() - noteCounter[2]);
        atm.setBanknote50(atm.getBanknote50() - noteCounter[1]);
        atm.setBanknote100(atm.getBanknote100() - noteCounter[0]);
        atmService.update(atm);

        return new ResponseEntity<Object>(sum, HttpStatus.OK);
    }

}
