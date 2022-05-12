package com.fantastik4.prisonsystemapplication.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component

public class Guard extends User implements Serializable {

    private String email;
    private String phoneNumber;


    public Guard( String email, String phoneNumber) {

        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Guard() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    @Override
    public String toString() {
        return "Guard{" +
                "id=" + super.getId() +
                ", password='" + super.getPassword() + '\'' +
                ", userName='" + super.getUsername() + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


