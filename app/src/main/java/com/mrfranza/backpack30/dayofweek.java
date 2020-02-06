package com.mrfranza.backpack30;

//Base class to hold information about the property
public class dayofweek {

    //property basics
    private String dayWeekName;
    private String image;


    //constructor
    public dayofweek(String dayWeekName,String image){
        this.dayWeekName = dayWeekName;
        this.image = image;
    }

    //getters
    String getDayName() { return dayWeekName; }
    String getImage() { return image; }
}