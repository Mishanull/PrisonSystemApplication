package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Prisoner;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrisonerServiceImpl implements PrisonerService{

    private final RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public PrisonerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }

    @Override
    public String createPrisoner(String jsonPrisoner) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonPrisoner, headers);

        try{
            return restTemplate.postForObject("https://localhost:7150/Prisoner", request, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String removePrisoner(Long id) {
        try {
            restTemplate.delete("https://localhost:7150/Prisoner/{id}",id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getPrisonerById(Long prisonerId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Prisoner/{id}", String.class, prisonerId);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getPrisoners(String pageNumber, String pageSize) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Prisoner?pageNumber="+pageNumber+"&pageSize="+pageSize, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String GetNumPrisPerSectAsync() {
        try{
            return restTemplate.getForObject("https://localhost:7150/Prisoner/numPerSect", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String AddPointsToPrisoner(String[] idAndPoints) {
        try {
            String[] request=new String[2];
            request[0]=idAndPoints[0];
            request[1]=idAndPoints[1];

            restTemplate.patchForObject("https://localhost:7150/Visit", request, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String updatePrisoner(String jsonPrisoner) {
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

    @Override
    public String getPrisonerBySSN(String ssn) {
        try{
            ResponseEntity<String> response=restTemplate.getForEntity("https://localhost:7150/Prisoner/ssn/{ssn}",String.class,ssn);
            return response.getBody();
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}