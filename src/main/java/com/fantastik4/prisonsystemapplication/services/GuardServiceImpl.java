package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.GuardsList;
import com.fantastik4.prisonsystemapplication.model.PrisonersList;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Guard addPGuard(Guard newGuard) {
        try {

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
    public Guard removeGuard(Guard releasedGuard) {
        try {
            restTemplate.delete("https://localhost:7150/Guard", releasedGuard, Guard.class);
            return releasedGuard;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Guard updateGuard(Guard updateGuard) {
        try {
            restTemplate.put("https://localhost:7150/Guard", updateGuard, Guard.class);
            return updateGuard;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Guard getGuardById(Long guardId) {
        try {
            return restTemplate.getForObject("https://localhost:7150/Guard", Guard.class, guardId);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override public List<Guard> getGuards() {
        try {
            GuardsList guardsList = restTemplate.getForObject("https://localhost:7150/Guards", GuardsList.class);

            if (guardsList == null) return null;
            else return guardsList.getGuards();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
