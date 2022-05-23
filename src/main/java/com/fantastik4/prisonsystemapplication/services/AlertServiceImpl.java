package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Alert;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class AlertServiceImpl implements AlertService {
    private RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public AlertServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }
    @Override
    public String getAlerts() {
        try{
            String response=restTemplate.getForObject("https://localhost:7150/Alert", String.class);
            List<Alert> alertList=gson.fromJson(response,List.class);
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createAlert(String alertJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(alertJson, headers);

        try{
            restTemplate.postForObject("https://localhost:7150/Alert", request, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
