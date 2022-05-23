package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Prisoner;
import com.fantastik4.prisonsystemapplication.models.Visit;
import com.fantastik4.prisonsystemapplication.models.enums.Status;
import com.fantastik4.prisonsystemapplication.utils.PasswordGenerator;
import com.google.gson.*;
import org.apache.tomcat.jni.Local;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    public String CreateVisit(String jsonVisit) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Visit v = gson.fromJson(jsonVisit, Visit.class);
            Prisoner p = restTemplate.getForObject("https://localhost:7150/Prisoner/ssn/"+v.getPrisonerSsn(), Prisoner.class);

            if (p.points < 5) {
                v.setStatus(Status.Denied);
                jsonVisit = gson.toJson(v);
                HttpEntity<String> request = new HttpEntity<>(jsonVisit, headers);
                restTemplate.postForObject("https://localhost:7150/Visit", request, String.class);
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
    public String GetVisits(String pageNumber, String pageSize) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Visit?pageNumber="+pageNumber+"&pageSize="+pageSize, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String GetVisitByAccessCode(String code) {
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
    public String UpdateVisitStatus(String[] statusAndId) {
        try {
            String[] request=new String[3];
            request[0]=statusAndId[0];
            request[1]=statusAndId[1];
            if(statusAndId[1].equalsIgnoreCase("approved")){
                String accessCode= PasswordGenerator.generate(8);
                request[2]=accessCode;
            }

            restTemplate.patchForObject("https://localhost:7150/Visit", request, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
