package com.fantastik4.applicationtier.services;

import com.fantastik4.applicationtier.model.Prisoner;
import org.springframework.stereotype.Service;

@Service
public interface PrisonerService {
    String addPrisoner(String newPrisoner);
    Prisoner removePrisoner(Prisoner releasedPrisoner);
    Prisoner getPrisoner(Long prisonerId);
}
