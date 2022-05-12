package com.fantastik4.prisonsystemapplication.model;

import java.util.ArrayList;
import java.util.List;

public class WorkShiftList {
    private List<WorkShift> shifts;

    public WorkShiftList(List<WorkShift> shifts) {
        this.shifts = shifts;
    }

    public WorkShiftList() {
        shifts = new ArrayList<>();
    }

    public List<WorkShift> getWorkShifts() {
        return shifts;
    }

    public void setWorkShifts(List<WorkShift> shifts)
    {
        this.shifts = shifts;
    }
}
