package com.example.notesapp;

public class Note {
    private String note;
    private String time;

    public Note(String note) {
        this.note = note;
        this.time = ""+System.currentTimeMillis();
    }

    public String getNote() {
        return note;
    }

    public String getTime() {
        return time;
    }
}
