package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.WorkShift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkShiftService {
    String createWorkShift(String shift);
    String removeWorkShift(Long id);
    List<WorkShift> getWorkShifts();
    String updateWorkShift(String jsonWorkShift);
    String addGuardToWorkShift(String guardId, String shiftId);
    String setGuardsInWorkShift(List<String> jsonWorkShift);
    String removeGuardFromWorkShift(String guardId, String shiftId);
}
