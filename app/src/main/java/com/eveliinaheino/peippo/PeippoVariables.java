package com.eveliinaheino.peippo;

public class PeippoVariables {
    private int tiredness;
    private int mood;
    private int timeOfDay; // before sleep = 0, after sleep = 1
    private int sleptHours;

    public PeippoVariables(int timeOfDay, int tiredness, int mood){
        this.tiredness = tiredness;
        this.mood = mood;
        this.timeOfDay = timeOfDay;
    }
    public PeippoVariables(int timeOfDay, int tiredness, int mood, int sleptHours){
        this.tiredness = tiredness;
        this.mood = mood;
        this.timeOfDay = timeOfDay;
        this.sleptHours = sleptHours;
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
    public int getSleptHours (){
        return this.sleptHours;
    }
}
