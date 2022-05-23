package com.fantastik4.prisonsystemapplication.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Prisoner.class)
public class Prisoner implements Serializable {
    public long id;
    public String  firstName;
    public String  lastName;
    public int ssn;
    public String crimeCommitted;
    public int points;
//    public LocalDateTime entryDate;
    public Date entryDate;
    public Date releaseDate;
    public Sector sector;
    public List<Note> notes;

    public Prisoner() {
    }

    public Prisoner(long id, String firstName, String lastName, int ssn, String crimeCommitted, int points, List<Note> notes, Date entryDate, Date releaseDate, Sector sector) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.crimeCommitted = crimeCommitted;
        this.points = points;
        this.notes = notes;
        this.entryDate = entryDate;
        this.releaseDate = releaseDate;
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
                ", note='" + notes + '\'' +
                ", entryDate=" + entryDate +
                ", durationInMonths=" + releaseDate +
                '}';
    }
}
