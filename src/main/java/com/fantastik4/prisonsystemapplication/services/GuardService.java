package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import org.springframework.stereotype.Service;

@Service
public interface GuardService {
    Guard addPGuard(Guard newGuard);
    Guard removeGuard(Guard releasedGuard);
    Guard updateGuard(Guard updateGuard);
    Guard getGuard(Long guardId);
}
