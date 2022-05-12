package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.WorkShift;

import java.util.List;

public interface WorkShiftService {
    String createWorkShift(String shift);
    String removeWorkShift(Long id);
    List<WorkShift> getWorkShifts();
    String updateWorkShift(String jsonWorkShift);
    String addGuardToWorkShift(Long guardId, Long shiftId);
    String setGuardsInWorkShift(List<Guard> jsonWorkShift);
    String removeGuardFromWorkShift(Long guardId, Long shiftId);
}
