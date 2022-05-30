package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public interface AlertService {
    String getAlerts(String pageNumber, String pageSize);
    void createAlert(String alertJson);
    String getAlertsToday();
}
