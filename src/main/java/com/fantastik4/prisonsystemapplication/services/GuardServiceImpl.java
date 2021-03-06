package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Guard;
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
            return restTemplate.getForObject("https://localhost:7150/Guard", String.class);

        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getGuardBySector(long id) {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/{id}/Sector",String.class,id);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getGuardsPerSectToday(long sectorId) {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/guardsSectorToday/{sectorId:long}",String.class,sectorId);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getNumGuardsPerSect() {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/numPerSector", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String getNumGuardsPerSectToday() {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/numPerSectorToday", String.class);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String isGuardAssigned(long guardId) {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/assigned/{id:long}",String.class,guardId);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String isGuardWorking(long guardId) {
        try{
            return restTemplate.getForObject("https://localhost:7150/Guard/working/{id:long}",String.class,guardId);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
