package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Visit;

import java.util.List;

public interface VisitService {
    String CreateVisit(String visit);
    String GetVisits(String pageNumber, String pageSize);
    String GetVisitByAccessCode(String code);
    String UpdateVisitStatus(String[] statusAndId);
}
