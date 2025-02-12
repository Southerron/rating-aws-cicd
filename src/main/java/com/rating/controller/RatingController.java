package com.rating.controller;

import com.rating.model.ProfessionDomainList;
import com.rating.service.JsonReaderService;
import com.rating.service.RatingDomainService;
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


    @GetMapping(produces = "application/json", value = "/professions")
    public ResponseEntity<ProfessionDomainList> getProfessionDomain() {
        ProfessionDomainList professionDomainList =  ratingDomainService.getProfessionFromJson();

        return new ResponseEntity<>(professionDomainList, HttpStatus.OK);
    }

}
