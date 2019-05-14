package com.example.projektas;

public class ReminderModel {
    private int id;
    private String text;
    private String date;

    public ReminderModel(int id, String date, String text){
        this.id = id;
        this.date = date;
        this.text = text;
    }

    public int getId(){return  this.id;}

    public String getText(){
        return this.text;
    }

    public String getDate(){
        return this.date;
    }
}
