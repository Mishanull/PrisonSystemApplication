package com.fantastik4.prisonsystemapplication.services;


public interface VisitService {
    String createVisit(String visit);
    String getVisits(String pageNumber, String pageSize);
    String getVisitByAccessCode(String code);
    String updateVisitStatus(String[] statusAndId);
    String GetNumVisitsTodayAsync();
}
