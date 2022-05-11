package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.GuardsList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuardService {
    Guard addGuard(Guard newGuard);
    String removeGuard(Long id);
    String updateGuard(String jsonGuard);
    Guard getGuardById(Long guardId);
    List<Guard> getGuards();
}
