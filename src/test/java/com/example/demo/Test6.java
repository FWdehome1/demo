package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test6 {
    public static void main(String[] args) {



            int i = 1;
            while (i > 0) {
                i++;

            }
                 System.out.println(i);
            System.out.println(Math.abs(i + 2020));





        String  contry="123";
        String  contry2=new String("123");
        System.out.println(Arrays.toString(contry.getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString(contry2.getBytes(StandardCharsets.UTF_8)));
        Person person = new Person();
        person.name = "Bob";
        person.money = 0;
        // Check the person, if he has no money, set it as null
        check(person);
        // If the person turned to null, print he has no money, otherwise print he's rich
        if (person == null) {
            System.out.println(person.name + " has no money.");
        } else {
            System.out.println(person.name + " is rich.");
        }
    }

    private static void check(Person person) {
        if (person.money <= 0) {
            person = null;
        }
    }


    }

