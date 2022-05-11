package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PrisonerService {
    String addPrisoner(String newPrisoner);
    String removePrisoner(Long id);
    Prisoner getPrisonerById(Long prisonerId);
    List<Prisoner> getPrisoners();
    String updatePrisoner(String jsonPrisoner);
}
