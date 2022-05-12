package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrisonerService {
    String createPrisoner(String newPrisoner);
    String removePrisoner(Long id);
    String getPrisonerById(Long prisonerId);
    String getPrisoners();
    String updatePrisoner(String jsonPrisoner);
}
