package com.example.esservizilogging.controllers;

import com.example.esservizilogging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class BasicController {

    private Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private BasicService basicService;

    @GetMapping("/")
    public String welcome() {
        logger.info("Welcoming the user");
        return "Welcome!";
    }

    @GetMapping("/exp")
    public Integer power() {
        Integer base = Integer.parseInt(environment.getProperty("customVars.base"));
        Integer exp = Integer.parseInt(environment.getProperty("customVars.exp"));
        return basicService.power(base, exp);
    }

    @GetMapping("/get-errors")
    public void getError() {
        Error error = new Error("This is an error");
        logger.info("There is an error", error);
        throw error;
    }
}
