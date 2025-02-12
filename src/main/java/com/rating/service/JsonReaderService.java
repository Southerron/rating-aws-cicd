package com.rating.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rating.model.ProfessionDomainList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class JsonReaderService {
    private static final Logger log = LoggerFactory.getLogger(JsonReaderService.class);
    public static final String EXT = ".json";

    public JsonReaderService() {
    }

    public ProfessionDomainList getJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        ProfessionDomainList professionDomainList = new ProfessionDomainList();
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("json/profession-list.json");
            professionDomainList = objectMapper.readValue(inputStream, ProfessionDomainList.class);
            // Read JSON file and convert to Java object
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return professionDomainList;

    }
}




