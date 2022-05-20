package com.fantastik4.prisonsystemapplication.models;

import java.time.LocalDateTime;

public class Visit {
    private Long id;
    private LocalDateTime visitDate;
    private LocalDateTime visitTime;
    private Status status0;
    private String accessCode;
    private String  firstName;
    private String  lastName;
    private String email;
    private int prisonerSsn;

    public enum Status
    {
        Waiting,
        Denied,
        Approved,
        OnVisit,
        Left
    }
}
