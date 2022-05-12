package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WorkShiftServiceImpl implements WorkShiftService{

    private final RestTemplate restTemplate;

    @Autowired
    public WorkShiftServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String createWorkShift(String jsonShift) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonShift, headers);

            return restTemplate.postForObject("https://localhost:7150/Prisoner", request, String.class);
    }

    @Override
    public String removeWorkShift(Long id) {
        try {
            restTemplate.delete("https://localhost:7150/Prisoner/{id}",id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
    }

    @Override
    public List<WorkShift> getWorkShifts() {
        try {
            WorkShiftList workShiftList = restTemplate.getForObject("https://localhost:7150/Prisoner", WorkShiftList.class);

            if (workShiftList == null) return null;
            else return workShiftList.getWorkShifts();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateWorkShift(String jsonWorkShift) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(jsonWorkShift, headers);
            restTemplate.patchForObject("https://localhost:7150/Guard", request, WorkShift.class);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String addGuardToWorkShift(Long guardId, Long shiftId) {
        return null;
    }

    @Override
    public String setGuardsInWorkShift(List<Guard> jsonWorkShift) {
        return null;
    }

    @Override
    public String removeGuardFromWorkShift(Long guardId, Long shiftId) {
        return null;
    }
}
