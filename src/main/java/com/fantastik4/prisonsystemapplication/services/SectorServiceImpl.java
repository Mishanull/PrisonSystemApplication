package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.SectorList;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SectorServiceImpl implements SectorService{

    private RestTemplate restTemplate;
    public SectorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getSectors() {
        try {
            SectorList sectorList = restTemplate.getForObject("https://localhost:7150/Sector", SectorList.class);
            return new Gson().toJson(sectorList.getSectors());
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
