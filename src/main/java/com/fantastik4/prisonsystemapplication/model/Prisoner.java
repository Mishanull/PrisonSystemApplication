package com.fantastik4.prisonsystemapplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Prisoner.class)
public class Prisoner {

    public long Id;
    public String  Firstname;
    public String  Lastname;
    public int Ssn;
    public String CrimeCommitted;
    public int Points;
    public String Note;


    public Prisoner() {
    }

    public Prisoner(long id, String firstname, String lastname, int ssn, String crimeCommitted, int points, String note) {
        Id = id;
        Firstname = firstname;
        Lastname = lastname;
        Ssn = ssn;
        CrimeCommitted = crimeCommitted;
        Points = points;
        Note = note;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getSsn() {
        return Ssn;
    }

    public void setSsn(int ssn) {
        Ssn = ssn;
    }

    public String getCrimeCommitted() {
        return CrimeCommitted;
    }

    public void setCrimeCommitted(String crimeCommitted) {
        CrimeCommitted = crimeCommitted;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "Id=" + Id +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Ssn=" + Ssn +
                ", CrimeCommitted='" + CrimeCommitted + '\'' +
                ", Points=" + Points +
                ", Note='" + Note + '\'' +
                '}';
    }
}
