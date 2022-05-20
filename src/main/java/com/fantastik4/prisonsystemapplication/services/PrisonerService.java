package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public interface PrisonerService {
    String createPrisoner(String newPrisoner);
    String removePrisoner(Long id);
    String getPrisonerById(Long prisonerId);
    String getPrisoners();
    String updatePrisoner(String jsonPrisoner);
}
