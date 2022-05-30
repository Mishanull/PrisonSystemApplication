package com.fantastik4.prisonsystemapplication.models;

import com.fantastik4.prisonsystemapplication.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Visit {
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssX")
    @JsonSetter
    private Date visitDate;
    private Status status;
    private String accessCode;
    private String  firstName;
    private String  lastName;
    private String email;
    private int prisonerSsn;

    public Visit() {
    }

    public Visit(Long id, Date visitDate, Status status, String accessCode, String firstName, String lastName, String email, int prisonerSsn) {
        this.id = id;
        this.visitDate = visitDate;
        this.status = status;
        this.accessCode = accessCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.prisonerSsn = prisonerSsn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
