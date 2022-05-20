package com.fantastik4.prisonsystemapplication.models;

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
//    public LocalDateTime entryDate;
    public String entryDate;
    public int durationInMonths;
    public Sector sector;

    public Prisoner() {
    }

    public Prisoner(long id, String firstName, String lastName, int ssn, String crimeCommitted, int points, String note, String entryDate, int durationInMonths, Sector sector) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.crimeCommitted = crimeCommitted;
        this.points = points;
        this.note = note;
        this.entryDate = entryDate;
        this.durationInMonths = durationInMonths;
        this.sector = sector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
