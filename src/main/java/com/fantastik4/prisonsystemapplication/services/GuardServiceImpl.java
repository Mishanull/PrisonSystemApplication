package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.GuardsList;
import com.fantastik4.prisonsystemapplication.utils.UsernameGenerator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GuardServiceImpl implements GuardService{
    private RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public GuardServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }

    @Override
    public String createGuard(Guard newGuard) {
        try {
            newGuard.setUsername(UsernameGenerator.generate(newGuard.getFirstName(),newGuard.getLastName()));
            Guard g = restTemplate.postForObject("https://localhost:7150/Guard", newGuard, Guard.class);
            return gson.toJson(g);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String removeGuard(Long id) {
        try {
            restTemplate.delete("https://localhost:7150/Guard/{id}", id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String updateGuard(String jsonGuard) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonGuard, headers);
            restTemplate.patchForObject("https://localhost:7150/Guard", request, Guard.class);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getGuardById(Long guardId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Guard/{id}", String.class, guardId);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override public String getGuards() {
        try {
            GuardsList guardsList = restTemplate.getForObject("https://localhost:7150/Guard", GuardsList.class);
            assert guardsList != null;
            return gson.toJson(guardsList.getGuards());
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
