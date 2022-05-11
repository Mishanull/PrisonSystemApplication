package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import com.fantastik4.prisonsystemapplication.model.PrisonersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

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
    public Prisoner getPrisonerById(Long prisonerId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Prisoner/{prisonerId}", Prisoner.class, prisonerId);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Prisoner> getPrisoners() {
        try {
            PrisonersList prisonersList = restTemplate.getForObject("https://localhost:7150/Prisoner", PrisonersList.class);

            if (prisonersList == null) return null;
            else return prisonersList.getPrisoners();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Prisoner updatePrisoner(String jsonPrisoner) {
        //ToDo - unchecked, check if it works !
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonPrisoner, headers);
        return restTemplate.patchForObject("https://localhost:7150/Prisoner", request, Prisoner.class);
    }
}
