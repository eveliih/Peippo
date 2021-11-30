package com.eveliinaheino.peippo;

public class GetFeedbackMessage {
    private int mood;
    private int tiredness;
    private int sleptHours;

    public GetFeedbackMessage(int mood, int tiredness, int sleptHours){
        this.mood = mood;
        this.tiredness = tiredness;
        this.sleptHours = sleptHours;
    }

    public GetFeedbackMessage(int mood, int tiredness){
        this.mood = mood;
        this.tiredness = tiredness;
    }

    public String getMoodMessage(){
        if(this.mood == 1){
            return "Mielialasi on 1";
        }else if(this.mood == 2){
            return "Mielialasi on 2";
        }else if(this.mood == 3){
            return "Mielialasi on 3";
        }else if(this.mood == 4){
            return "Mielialasi on 4";
        }else if(this.mood == 5){
            return "Mielialasi on 5";
        }return "Valitse mielialan arvo ennen tallentamista";
    }

    public String getTirednessMessage(){
        if(this.tiredness == 1){
            return "Väsymys on 1";
        }else if(this.tiredness == 2){
            return "Väsymys on 2";
        }else if(this.tiredness == 3){
            return "Väsymys on 3";
        }else if(this.tiredness == 4){
            return "Väsymys on 4";
        }else if(this.tiredness == 5){
            return "Väsymys on 5";
        }return "Valitse väsymyksen arvo ennen tallentamista";
    }

    public String getSleepHrsMessage(){ //näitä pitää vielä muokata. Ehkä varmistaa jo aikaisemmassa vaiheessa ettei alle nollan arvoja hyväksytä?
        if(this.sleptHours > 0 && this.sleptHours < 6){
            return " nukuit 1-5 h";
        }else if(this.sleptHours > 6 && this.sleptHours < 11){
            return "Nukuit 5- 10h";
        }else if(this.sleptHours > 10){
            return "Nukuit yli 10h";
        }else if(this.sleptHours < 0){
            return "Arvo alle 0. Ei kelpaa";
        }return "Jotain muuta tapahtui";
    }
}

