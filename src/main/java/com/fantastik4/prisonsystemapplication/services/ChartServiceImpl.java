package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Prisoner;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bouncycastle.asn1.eac.BidirectionalMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

@Service
public class ChartServiceImpl implements ChartService {
    private PrisonerService prisonerService;
    private Gson gson;
    @Autowired
    private ChartServiceImpl(PrisonerService prisonerService){
        this.prisonerService=prisonerService;
        this.gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
    }
    @Override
    public String getChartData() {
        Type prisonerListType=new TypeToken<List<Prisoner>>(){}.getType();
        List<Prisoner> prisoners=gson.fromJson(prisonerService.getPrisoners(String.valueOf(0), String.valueOf(0)), prisonerListType);
        Map<String,Integer> data=new HashMap<>();
        int[] counts=new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        for(Prisoner p : prisoners){
                if ( p.entryDate.getYear()+1900 ==LocalDate.now().getYear()) {
                    counts[p.entryDate.getMonth()]++;
                }
        }
        data.put("January",counts[0]);
        data.put("February",counts[1]);
        data.put("March",counts[2]);
        data.put("April",counts[3]);
        data.put("May",counts[4]);
        data.put("June",counts[5]);
        data.put("July",counts[6]);
        data.put("August",counts[7]);
        data.put("September",counts[8]);
        data.put("October",counts[9]);
        data.put("November",counts[10]);
        data.put("December",counts[11]);
        return gson.toJson(data);
    }
}
