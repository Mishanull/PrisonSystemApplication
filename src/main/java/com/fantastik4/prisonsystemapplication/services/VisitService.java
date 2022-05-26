package com.fantastik4.prisonsystemapplication.services;


public interface VisitService {
    String CreateVisit(String visit);
    String GetVisits(String pageNumber, String pageSize);
    String GetVisitByAccessCode(String code);
    String UpdateVisitStatus(String[] statusAndId);
    String GetNumVisitsTodayAsync();
}
