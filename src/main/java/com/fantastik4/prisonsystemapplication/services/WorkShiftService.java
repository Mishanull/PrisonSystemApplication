package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.WorkShift;

import java.util.List;

public interface WorkShiftService {
    String createWorkShift(String shift);
    String removeWorkShift(Long id);
    List<WorkShift> getWorkShifts();
    String updateWorkShift(String jsonWorkShift);
    String addGuardToWorkShift(String guardId, String shiftId);
    String removeGuardFromWorkShift(String guardId, String shiftId);
}
