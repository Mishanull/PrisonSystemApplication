package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;


@Service
public interface WorkShiftService {
    String createWorkShift(String shift);
    String removeWorkShift(Long id);
    String getWorkShifts();
    String getWorkShiftById(Long id);
    String updateWorkShift(String jsonWorkShift);
    String addGuardToWorkShift(String[] guardIdAndShiftId);
    String removeGuardFromWorkShift(String[] guardIdAndShiftId);
}
