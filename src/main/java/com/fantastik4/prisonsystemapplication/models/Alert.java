package com.fantastik4.prisonsystemapplication.models;

import com.fantastik4.prisonsystemapplication.models.enums.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class Alert implements Serializable {
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssX")
    private Date date;
    private String text;
    private Priority priority;
    private int durationInMinutes;
    private boolean[] sectors =new boolean[3];

    public Alert() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public boolean[] getSectors() {
        return sectors;
    }

    public void setSectors(boolean[] sectors) {
        this.sectors = sectors;
    }
}
