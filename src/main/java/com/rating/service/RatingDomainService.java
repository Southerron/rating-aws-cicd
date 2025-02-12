package com.rating.service;

import com.rating.model.ProfessionDomainList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingDomainService {

    @Autowired
    private JsonReaderService jsonReaderService;

    public ProfessionDomainList getProfessionFromJson() {

        try {
            System.out.println("Sleeping for 50 milliseconds...");
            Thread.sleep(50); // Sleep for 50 milliseconds
            System.out.println("Awake now!");
        } catch (InterruptedException e) {
            System.err.println("Sleep was interrupted!");
            e.printStackTrace();
        }
        return jsonReaderService.getJson();


    }

}
