package com.fantastik4.prisonsystemapplication.services;

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
            return restTemplate.getForObject("https://localhost:7150/Sector", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
