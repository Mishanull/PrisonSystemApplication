package com.fantastik4.prisonsystemapplication.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class UsernameGenerator {
    public static String generate(String firstName, String lastName){
        Random random=new Random();
        //third party library that generates fake data
        Faker faker=new Faker();
        //if first name or last name have less than 2 characters, generate random names
        if(firstName.length()<2 || lastName.length()<2){
             firstName= faker.name().firstName();
             lastName=faker.name().lastName();
        }
        return firstName.substring(0,3)+"_"+lastName.substring(0,3)+(random.nextInt(100-10)+10);
    }
}
