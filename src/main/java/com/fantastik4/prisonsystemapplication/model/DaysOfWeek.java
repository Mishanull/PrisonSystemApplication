package com.fantastik4.prisonsystemapplication.model;

import java.util.List;

public class DaysOfWeek {
    private long id;
    private DayOfweeks day;
    private WorkShiftList WorkShifts;
    public enum DayOfweeks{
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayOfweeks getDay() {
        return day;
    }

    public void setDay(DayOfweeks day) {
        this.day = day;
    }

    public WorkShiftList getWorkShifts() {
        return WorkShifts;
    }

    public void setWorkShifts(WorkShiftList workShifts) {
        WorkShifts = workShifts;
    }

    @Override
    public String toString() {
        return "DaysOfWeek{" +
                "id=" + id +
                ", day=" + day +
                ", WorkShifts=" + WorkShifts +
                '}';
    }
}
