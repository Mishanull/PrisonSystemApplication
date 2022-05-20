package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Alert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlertService {
    String getAlerts();
    void createAlert(String alertJson);
}
