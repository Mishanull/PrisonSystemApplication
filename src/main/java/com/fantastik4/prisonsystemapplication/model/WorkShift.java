package com.fantastik4.prisonsystemapplication.model;
import org.apache.tomcat.jni.Time;

import java.util.List;

public class WorkShift {
    private Long id;
    private Sector Sector;
    private Time Start;
    private Time End;
    private List<String>  Days;
    private List<Guard> guards;

    public WorkShift(Long id, Sector sector, Time start, Time end, List<String> days) {
        this.id = id;
        Sector = sector;
        Start = start;
        End = end;
        Days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sector getSector() {
        return Sector;
    }

    public void setSector(Sector sector) {
        Sector = sector;
    }

    public Time getStart() {
        return Start;
    }

    public void setStart(Time start) {
        Start = start;
    }

    public Time getEnd() {
        return End;
    }

    public void setEnd(Time end) {
        End = end;
    }

    public List<String> getDays() {
        return Days;
    }

    public void setDays(List<String> days) {
        Days = days;
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
                ", Sector='" + Sector + '\'' +
                ", Start=" + Start +
                ", End=" + End +
                ", Days=" + Days +
                ", guards=" + guards +
                '}';
    }

    public enum Sector{
        SectorA,
        SectorB,
        SectorC,
        SectorD,
        SectorE,
        SectorF,
        SectorG
    }
}
