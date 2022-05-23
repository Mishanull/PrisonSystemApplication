package com.fantastik4.prisonsystemapplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Visit.class)
public class Visit implements Serializable {
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
        Approved
    }
}
