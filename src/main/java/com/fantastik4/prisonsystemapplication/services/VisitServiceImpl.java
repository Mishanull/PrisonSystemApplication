package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final RestTemplate restTemplate;

    @Autowired
    public VisitServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String CreateVisit(String jsonVisit) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonVisit, headers);

        return restTemplate.postForObject("https://localhost:7150/Visit", request, String.class);
    }

    @Override
    public List<Visit> GetVisits() {
        try {
            List<Visit> visitList = (List<Visit>) restTemplate.getForObject("https://localhost:7150/WorkShift", Visit.class);

            return visitList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String GetVisitByAccessCode(String code) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Visit", String.class, code);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String UpdateVisitStatus(String id, String status) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(id, headers);
            HttpEntity<String> request2 = new HttpEntity<>(status, headers);
            restTemplate.patchForObject("https://localhost:7150/Visit", request, Visit.class, request2, Visit.Status.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
