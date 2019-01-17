package com.infoworld.controller;

import com.infoworld.model.Amount;
import com.infoworld.model.Atm;
import com.infoworld.service.AtmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.infoworld.common.Responses.newEntityOrError;

/**
 * Created by Claudiu on 01/17/2018.
 */
@Controller
public class AtmController {

    private final Logger logger = LoggerFactory.getLogger(AtmController.class);

    @Autowired
    AtmService atmService;

    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public ResponseEntity<Amount> getAmount(@RequestParam("amount") Integer amount) {
        Atm atm = atmService.findById(1);
        Amount sum = new Amount();
        return newEntityOrError(() -> sum);
    }
}
