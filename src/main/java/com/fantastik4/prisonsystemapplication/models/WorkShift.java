package com.fantastik4.prisonsystemapplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = WorkShift.class)
public class WorkShift implements Serializable {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Sector sector;
    private String daysOfWeek;
    private List<Guard> guards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkShift() {}

    public WorkShift(Long id, LocalDateTime start, LocalDateTime end, Sector sector, String daysOfWeek, List<Guard> guards) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.sector = sector;
        this.daysOfWeek = daysOfWeek;
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
