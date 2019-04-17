package com.example.listviewcustomadapter;

public class Student {
    private String name, surname,contact,address;

    public Student(String name, String surname, String contact, String address) {
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
}
