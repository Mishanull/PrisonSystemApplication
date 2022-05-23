package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.*;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WorkShiftServiceImpl implements WorkShiftService{

    private final RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public WorkShiftServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }

    @Override
    public String createWorkShift(String jsonShift) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonShift, headers);

            return restTemplate.postForObject("https://localhost:7150/WorkShift", request, String.class);
    }

    @Override
    public String removeWorkShift(Long id) {
        try {
            restTemplate.delete("https://localhost:7150/WorkShift/{id}",id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
    }

    @Override
    public String getWorkShifts() {
        try {
            return restTemplate.getForObject("https://localhost:7150/WorkShift", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override public String getWorkShiftById(Long id) {
        try {
            return restTemplate.getForObject("https://localhost:7150/WorkShift/{id}", String.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String updateWorkShift(String jsonWorkShift) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonWorkShift, headers);
            restTemplate.patchForObject("https://localhost:7150/WorkShift", request, WorkShift.class);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String addGuardToWorkShift(String[] guardIdAndShiftId) {
        try {
            String[] request=new String[3];
            request[0]=guardIdAndShiftId[0];
            request[1]=guardIdAndShiftId[1];

            restTemplate.patchForObject("https://localhost:7150/WorkShift/{id}", request, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    @Override
    public String removeGuardFromWorkShift(String[] guardIdAndShiftId) {
        try {
            String[] request=new String[3];
            request[0]=guardIdAndShiftId[0];
            request[1]=guardIdAndShiftId[1];

            restTemplate.patchForObject("https://localhost:7150/WorkShift", request, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
