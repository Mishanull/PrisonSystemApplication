package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuardService {
    String createGuard(Guard newGuard);
    String removeGuard(Long id);
    String updateGuard(String jsonGuard);
    String getGuardById(Long guardId);
    String getGuards();
}
