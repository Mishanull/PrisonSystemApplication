package com.fantastik4.applicationtier.services;

import com.fantastik4.applicationtier.model.Prisoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrisonerServiceImpl implements PrisonerService{
    private final RestTemplate restTemplate;
    @Autowired
    public PrisonerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String addPrisoner(String jsonPrisoner) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonPrisoner, headers);

        return restTemplate.postForObject("https://localhost:7150/Prisoner", request, String.class);
    }

    @Override
    public Prisoner removePrisoner(Prisoner releasedPrisoner) {
        try {
            restTemplate.delete("https://localhost:7150/Prisoner/" + releasedPrisoner.getId());
            return releasedPrisoner;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Prisoner getPrisoner(Long prisonerId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Prisoner/{prisonerId}", Prisoner.class, prisonerId);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
