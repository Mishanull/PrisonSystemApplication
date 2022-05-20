package com.fantastik4.prisonsystemapplication.models;

import com.fantastik4.prisonsystemapplication.models.enums.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
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

    public Visit(Long id, LocalDateTime visitDate, LocalDateTime visitTime, Status status0, String accessCode, String firstName, String lastName, String email, int prisonerSsn) {
        this.id = id;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.status0 = status0;
        this.accessCode = accessCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.prisonerSsn = prisonerSsn;
    }

    public Visit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public Status getStatus0() {
        return status0;
    }

    public void setStatus0(Status status0) {
        this.status0 = status0;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrisonerSsn() {
        return prisonerSsn;
    }

    public void setPrisonerSsn(int prisonerSsn) {
        this.prisonerSsn = prisonerSsn;
    }
}
