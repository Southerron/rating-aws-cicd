package com.rating.controller;

import com.rating.model.ProfessionDomainList;
import com.rating.service.JsonReaderService;
import com.rating.service.RatingDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingDomainService ratingDomainService;

    @Autowired
    private JsonReaderService jsonReaderService;

    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);


    @GetMapping(produces = "application/json", value = "/professions")

    public ResponseEntity<ProfessionDomainList> getProfessionDomain() {
        long startTime = System.currentTimeMillis();

        logger.info("Lambda function started at: " + startTime);

        ProfessionDomainList professionDomainList =  ratingDomainService.getProfessionFromJson();

        long endTime = System.currentTimeMillis();
        logger.info("Lambda function ended at: " + endTime);
        logger.info("Total execution time: " + (endTime - startTime) + " ms");

        return new ResponseEntity<>(professionDomainList, HttpStatus.OK);

    }

}
