package com.fantastik4.prisonsystemapplication.models;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class WorkShift {
    private Long id;
    private Date start;
    private Date end;
    private Sector sector;
    private String daysOfWeek;
    private List<Guard> guards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
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
                ", days=" + daysOfWeek +
                ", guards=" + guards +
                '}';
    }
}
