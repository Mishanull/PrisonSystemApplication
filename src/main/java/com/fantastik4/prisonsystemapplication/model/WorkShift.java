package com.fantastik4.prisonsystemapplication.model;
import org.apache.tomcat.jni.Time;

import java.util.List;

public class WorkShift {
    private Long id;
    private String Start;
    private String End;
    private List<Guard> guards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
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
                ", Start='" + Start + '\'' +
                ", End='" + End + '\'' +
                ", guards=" + guards +
                '}';
    }
}
