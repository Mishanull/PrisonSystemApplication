package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Prisoner;
import com.fantastik4.prisonsystemapplication.models.Visit;
import com.fantastik4.prisonsystemapplication.models.enums.Status;
import com.fantastik4.prisonsystemapplication.utils.PasswordGenerator;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VisitServiceImpl implements VisitService {

    private final RestTemplate restTemplate;
    private final EmailService emailService;
    private final Gson gson;

    @Autowired
    public VisitServiceImpl(RestTemplate restTemplate,EmailService emailService) {
        this.restTemplate = restTemplate;
        this.emailService=emailService;
        this.gson = new Gson();
    }

    @Override
    public String createVisit(String jsonVisit) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            Visit v = gson.fromJson(jsonVisit, Visit.class);
            Prisoner p = gson.fromJson(restTemplate.getForObject("https://localhost:7150/Prisoner/ssn/{ssn}", String.class,v.getPrisonerSsn()),Prisoner.class);


            if (p.points < 5) {
                HttpEntity<String> request = new HttpEntity<>(jsonVisit, headers);
                Visit replyVisit=gson.fromJson(restTemplate.postForObject("https://localhost:7150/Visit", request, String.class),Visit.class);
                updateVisitStatus(new String[]{String.valueOf(replyVisit.getId()),Status.Denied.toString()});
                return "denied";
            }
            else {
                HttpEntity<String> request = new HttpEntity<>(jsonVisit, headers);
                restTemplate.postForObject("https://localhost:7150/Visit", request, String.class);
                return "success";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getVisits(String pageNumber, String pageSize) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Visit?pageNumber="+pageNumber+"&pageSize="+pageSize, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getVisitByAccessCode(String code) {
        try {
            String visitJson = restTemplate.getForObject("https://localhost:7150/Visit/{accessCode}", String.class, code);
            assert visitJson != null;
            Visit v = gson.fromJson(visitJson,Visit.class);
            if (v.getAccessCode().equals("invalid")) {
                return "no";
            }
            else return visitJson;
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }

    }

    @Override
    public String updateVisitStatus(String[] statusAndId) {
        try {

            restTemplate.patchForObject("https://localhost:7150/Visit", statusAndId, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getVisitsToday() {
        try{
            return restTemplate.getForObject("https://localhost:7150/Visit/visitsToday", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getVisitsPending() {
        try{
            return restTemplate.getForObject("https://localhost:7150/Visit/visitsPending",String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}