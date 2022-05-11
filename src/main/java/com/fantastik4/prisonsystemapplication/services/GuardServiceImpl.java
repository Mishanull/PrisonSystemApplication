package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.GuardsList;
import com.fantastik4.prisonsystemapplication.model.PrisonersList;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GuardServiceImpl implements GuardService{
    private RestTemplate restTemplate;
    @Autowired
    public GuardServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Guard addGuard(Guard newGuard) {
        try {
            newGuard.setPassword("123456");
            Guard g=restTemplate.postForObject("https://localhost:7150/Guard", newGuard, Guard.class);
            System.out.println(g);
            return g;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
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
            return "false";
        }
    }

    @Override
    public String updateGuard(String jsonGuard) {
        try {
            Gson gson=new Gson();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonGuard, headers);
            restTemplate.patchForObject("https://localhost:7150/Guard", request, Guard.class);
            return "updated";
        }
        catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
    }

    @Override
    public Guard getGuardById(Long guardId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Guard/{id}", Guard.class, guardId);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override public List<Guard> getGuards() {
        try {
            GuardsList guardsList = restTemplate.getForObject("https://localhost:7150/Guard", GuardsList.class);

            if (guardsList == null) return null;
            else return guardsList.getGuards();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
