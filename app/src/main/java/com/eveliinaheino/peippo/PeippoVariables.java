package com.eveliinaheino.peippo;

/**
 * Luokasta voi luoda sovelluksessa käytettäviä arvoja sisältävän PeippoVariables-olion. Kaksi erilaista konstruktoria, joita käytetään illalla/aamulla.
 * Luokka sisältää metodit tiettyjen oliomuuttujien hakemiseen.
 * @author Eveliina
 */
public class PeippoVariables {
    private int tiredness;
    private int mood;
    private int sleptHours;
    private int day;
    private int month;

    public PeippoVariables(int tiredness, int mood, int day, int month){
        this.tiredness = tiredness;
        this.mood = mood;
        this.day = day;
        this.month = month;
    }
    public PeippoVariables(int tiredness, int mood, int sleptHours, int day, int month){
        this.tiredness = tiredness;
        this.mood = mood;
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

    public String getDate() { return day + "/" + month; }

    public int getSleptHours (){
        return this.sleptHours;
    }

}
