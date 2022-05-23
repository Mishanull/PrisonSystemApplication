package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.WorkShift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkShiftService {
    String createWorkShift(String shift);
    String removeWorkShift(Long id);
    String getWorkShifts();
    String getWorkShiftById(Long id);
    String updateWorkShift(String jsonWorkShift);
    String addGuardToWorkShift(String[] guardIdAndShiftId);
    String removeGuardFromWorkShift(long guardId, long shiftId);
}
