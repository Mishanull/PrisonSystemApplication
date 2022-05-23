package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public  interface PrisonerService {
    String createPrisoner(String newPrisoner);
    String removePrisoner(Long id);
    String getPrisonerById(Long prisonerId);
    String updatePrisoner(String jsonPrisoner);
    String getPrisonerBySSN(String ssn);
    //    String getPrisoners();
    String getPrisoners(String pageNumber, String pageSize);
}
