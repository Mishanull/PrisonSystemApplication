package com.fantastik4.prisonsystemapplication.model;

import java.util.Date;

public class Alert {
    private Date date;
    private String text;
    private Priority priority;
    public enum Priority{
        Low,
        Medium,
        High
    }
}
