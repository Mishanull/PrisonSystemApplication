package com.fantastik4.prisonsystemapplication.model;
import org.apache.tomcat.jni.Time;

import java.util.List;

public class WorkShift {
    private Long id;
    private String start;
    private String end;
    private Sector sector;
    private String daysOfWeeks;
    private List<Guard> guards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getDaysOfWeeks() {
        return daysOfWeeks;
    }

    public void setDaysOfWeeks(String daysOfWeeks) {
        this.daysOfWeeks = daysOfWeeks;
    }

    public List<Guard> getGuards() {
        return guards;
    }

    public void setGuards(List<Guard> guards) {
        this.guards = guards;
    }

    @Override
    public String toString() {
        return "WorkShift{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", sector=" + sector +
                ", daysOfWeeks=" + daysOfWeeks +
                ", guards=" + guards +
                '}';
    }
}
