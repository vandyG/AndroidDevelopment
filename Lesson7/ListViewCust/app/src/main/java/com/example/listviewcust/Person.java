package com.example.listviewcust;

import java.util.ArrayList;

public class Person {
    private String name, dob, address, photoUrl, phoneNo;
    private static ArrayList<Person> people = new ArrayList<>();

    public Person(String name, String dob, String address, String photoUrl, String phoneNo) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.photoUrl = photoUrl;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public static ArrayList<Person> getRandomPeople(){
        if(people == null){

        }
    }
}
