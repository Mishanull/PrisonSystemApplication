package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Visit;

import java.util.List;

public interface VisitService {
    String CreateVisit(String visit);
    List<Visit> GetVisits();
    String GetVisitByAccessCode(String code);
    String UpdateVisitStatus(String id, String status);
}
