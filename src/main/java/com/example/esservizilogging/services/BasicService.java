package com.example.esservizilogging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private Logger logger = LoggerFactory.getLogger(BasicService.class);

    public Integer power(Integer base, Integer exp) {
        logger.debug("Starting calculation");
        Integer result = 1;
        for (int i = 0; i < exp; i++) {
            result = result * base;
        }
        logger.debug("Calculation finished, returning result");
        return result;
    }
}
