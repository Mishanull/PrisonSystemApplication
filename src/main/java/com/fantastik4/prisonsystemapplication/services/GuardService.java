package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.GuardsList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuardService {
    Guard addGuard(Guard newGuard);
    Guard removeGuard(Guard releasedGuard);
    Guard updateGuard(Guard updateGuard);
    Guard getGuardById(Long guardId);
    List<Guard> getGuards();
}
