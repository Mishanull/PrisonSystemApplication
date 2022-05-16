package com.fantastik4.prisonsystemapplication.utils;

import java.util.Random;

public class PasswordGenerator {

    public static String generate(int length)
    {
        final String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char[] ch = new char[valid.length()];
        for (int i = 0; i < valid.length(); i++)
        {
            ch[i] = valid.charAt(i);
        }
        StringBuilder res = new StringBuilder();
        Random rnd = new Random();
        while (0 < length--)
        {
            res.append(ch[rnd.nextInt(valid.length())]);
        }
        return res.toString();
    }
}
