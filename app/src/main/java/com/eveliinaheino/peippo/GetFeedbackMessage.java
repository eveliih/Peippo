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

    public String getMoodMessageMorning(){
        if(this.mood == 1 || this.mood == 2){
            return "Arvioit mielialasi olevan huono. Huonosti nukuttu yö voi vaikuttaa myös mielialaan. Jokaiselle sattuu myös huonompia päiviä toisinaan. Jos mielialasi jatkuu huonona pitkään yhtäjaksoisesti, hakeudu terveydenhuollon ammattilaisen vastaanotolle. Voit seurata mielialaasi Tarkastele tietoja -osion avulla.";
        }else if(this.mood == 3){
            return "Arvioit mielialasi olevan neutraali."; //jotakin lisää?
        }else if(this.mood == 4 || this.mood == 5){
            return "Arvioit mielialasi olevan hyvä. Voisiko hyvin nukuttu yö vaikuttaa asiaan?";
        }return "Valitse mielialan arvo ennen tallentamista";
    }

    public String getMoodMessageEvening(){
        if(this.mood == 1 || this.mood == 2){
            return "Arvioit mielialasi olevan huono. Huolihetken pitäminen tai rentoutuminen ennen nukkumaanmenoa voi auttaa. Katso tarkempia ohjeita Vinkkejä parempaan uneen -osiosta.";
        }else if(this.mood == 3){
            return "Arvioit mielialasi olevan neutraali. Ilmeisesti mieltäsi ei paina mikään erityisemmin ja olet valmis nukkumaan yösi rauhallisesti.";
        }else if(this.mood == 4 || this.mood == 5){
            return "Arvioit mielialasi olevan hyvä. Hienoa! Mikä tästä päivästä teki erityisen mukavan? Voit kirjata ajatuksiasi ylös ja palata mukaviin muistoihin myöhemmin.";
        }return "Valitse mielialan arvo ennen tallentamista";
    }

    public String getTirednessMessageMorning(){
        if(this.tiredness == 1 || this.tiredness == 2){
            return "Nukuit " + this.sleptHours + " tuntia ja arivoit olevasi väsynyt. Nukuitko mahdollisesti liikaa tai liian vähän? Ole yhteydessä terveydenhuollon ammattilaiseen, jos tunnet olosi jatkuvasti väsyneeksi riittävistä yöunista huolimatta. Tarkastele tietojasi osion avulla voit saada käsityksen montako tuntia sinun tulee nukkua tunteaksesi olosi virkeäksi.\n\n";
        }else if(this.tiredness == 3){
            return "Nukuit " + this.sleptHours + " tuntia ja arivoit vireystasosi olevan keskitasoa. Syö vielä hyvä aamiainen ja olet valmiina päivän koitoksiin!\n\n";
        }else if(this.tiredness == 4 || this.tiredness == 5){
            return "Nukuit " + this.sleptHours + " tuntia ja arivioit olevasi virkeä. Hienoa! Tästä on hyvä aloittaa uusi päivä!\n\n";
        }return "Valitse väsymyksen arvo ennen tallentamista";
    }

    public String getTirednessMessageEvening(){
        if(this.tiredness == 1 || this.tiredness == 2){
            return "Arvioit olevasi väsynyt. Kaikki tuntevat olonsa joskus väsyneeksi. Toivottavasti saat nukuttua hyvin ja tunnet olosi virkeäksi aamulla! Nyt siis kipin kapin unten maille!\n\n";
        }else if(this.tiredness == 3){
            return "Arvioit virkeytesi olevan keskitasoa. \n\n"; //jotakin lisää?
        }else if(this.tiredness == 4 || this.tiredness == 5){
            return "Arvioit olevasi virkeä. Valitse jotakin rauhallista tekemistä ennen nukkumaanmenoa ja mene vuoteeseen vasta, kun tunnet olosi hieman väsyneeksi.\n\n";
        }return "Valitse väsymyksen arvo ennen tallentamista";
    }

    public String getSleepHrsMessage(){
        if(this.sleptHours >= 0 && this.sleptHours < 7){
            return "Aikuisen keskiverto unentarve on 7-9 tuntia. Nukuit vähemmän. Jos tunnet olosi virkeäksi, voi olla että pärjäät keskivertoa vähemmällä unella. Voit tarkastella tietojasi pidemmältä aikaväliltä Tarkastele tietoja -osiosta.\n\n";
        }else if(this.sleptHours > 6 && this.sleptHours < 10){
            return "Nukuit sopivasti aikuisen keskivertoon unentarpeeseen verrattuna. Omia keskiarvojasi voit tutkia Tarkastele tietojasi -osiosta.\n\n";
        }else if(this.sleptHours > 9){
            return "Aikuisen keskiverto unentarve on 7-9 tuntia. Nukuit yli yhdeksän tuntia. Liian pitkät yöunet voivat saada olosi tuntumaan väsyneelle. Jos nukut jatkuvasti hyvin pitkiä yöunia, lue lisää tietoa liikaunisuudesta Vinkkejä parempaan uneen -osiosta.\n\n";
        }else if(this.sleptHours < 0){
            return "Arvo alle 0. Ei kelpaa";
        }return "Jotain muuta tapahtui";
    }

    public String getFeedbackMorning(){
        return getTirednessMessageMorning() + getSleepHrsMessage() + getMoodMessageMorning();
    }

    public String getFeedbackEvening(){
        return getTirednessMessageEvening() + getMoodMessageEvening();
    }
}

