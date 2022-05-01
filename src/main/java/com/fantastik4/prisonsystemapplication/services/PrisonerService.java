package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import org.springframework.stereotype.Service;

@Service
public interface PrisonerService {
    String addPrisoner(String newPrisoner);
    Prisoner removePrisoner(Prisoner releasedPrisoner);
    Prisoner getPrisoner(Long prisonerId);
}
