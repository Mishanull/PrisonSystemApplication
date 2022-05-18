package com.fantastik4.prisonsystemapplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Prisoner.class)
public class Prisoner {

    public long id;
    public String  firstName;
    public String  lastName;
    public int ssn;
    public String crimeCommitted;
    public int points;
    public String note;
    public LocalDateTime entryDate;
    public int durationInMonths;


    public Prisoner() {
    }

    public Prisoner(long id, String firstName, String lastName, int ssn, String crimeCommitted, int points, String note, LocalDateTime entryDate, int durationInMonths) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.crimeCommitted = crimeCommitted;
        this.points = points;
        this.note = note;
        this.entryDate = entryDate;
        this.durationInMonths = durationInMonths;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getCrimeCommitted() {
        return crimeCommitted;
    }

    public void setCrimeCommitted(String crimeCommitted) {
        this.crimeCommitted = crimeCommitted;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn=" + ssn +
                ", crimeCommitted='" + crimeCommitted + '\'' +
                ", points=" + points +
                ", note='" + note + '\'' +
                ", entryDate=" + entryDate +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}
