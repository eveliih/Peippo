package com.eveliinaheino.peippo;

public class PeippoVariables {
    private int tiredness;
    private int mood;
    private int timeOfDay; // before sleep = 0, after sleep = 1
    private int sleptHours;
    private int day;
    private int month;

    public PeippoVariables(int timeOfDay, int tiredness, int mood, int day, int month){
        this.tiredness = tiredness;
        this.mood = mood;
        this.timeOfDay = timeOfDay;
        this.day = day;
        this.month = month;
    }
    public PeippoVariables(int timeOfDay, int tiredness, int mood, int sleptHours, int day, int month){
        this.tiredness = tiredness;
        this.mood = mood;
        this.timeOfDay = timeOfDay;
        this.sleptHours = sleptHours;
        this.day = day;
        this.month = month;
    }

    public int getMood() {
        return mood;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getTimeOfDay() {
        return timeOfDay;
    }

    public String getDate() { return day + "/" + month; }
    public int getSleptHours (){
        return this.sleptHours;
    }
}
