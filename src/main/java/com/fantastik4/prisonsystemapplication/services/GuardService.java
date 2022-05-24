package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Guard;
import org.springframework.stereotype.Service;

@Service
public interface GuardService {
    String createGuard(Guard newGuard);
    String removeGuard(Long id);
    String updateGuard(String jsonGuard);
    String getGuardById(Long guardId);
    String getGuards();

    String getGuardBySector(long id);
}
