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
    public String removePrisoner(Long id) {
        try {
            restTemplate.delete("https://localhost:7150/Prisoner/{id}",id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
    }

    @Override
    public Prisoner getPrisonerById(Long prisonerId) {
        try {

            return restTemplate.getForObject("https://localhost:7150/Prisoner/{id}", Prisoner.class, prisonerId);
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
    public String updatePrisoner(String jsonPrisoner) {
        //ToDo - unchecked, check if it works !
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonPrisoner, headers);
        try{
            restTemplate.patchForObject("https://localhost:7150/Prisoner", request, Prisoner.class);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
