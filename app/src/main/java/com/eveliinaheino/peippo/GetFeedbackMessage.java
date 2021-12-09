package com.eveliinaheino.peippo;

/**
 * Luokka pitää sisällään käyttäjän antamiin arvoihin perustuvat palautteet. Illalle sekä aamulle omat konstruktorit.
 */
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

    /**
     * Metodi hyödyntää tästä luokasta löytyviä muita metodeja, joiden avulla koostetaan käyttäjälle annettava palaute aamulla.
     * Muut metodit valitsevat palauttamansa viestin käyttäjän tallentaman arvon perusteella.
     */
    public String getFeedbackMorning(){
        return getTirednessMessageMorning() + getSleepHrsMessage() + getMoodMessageMorning();
    }
    /**
     * Metodi hyödyntää tästä luokasta löytyviä muita metodeja, joiden avulla koostetaan käyttäjälle palaute illalla.
     * Muut metodit valitsevat palauttamansa viestin käyttäjän tallentaman arvon perusteella.
     */
    public String getFeedbackEvening(){
        return getTirednessMessageEvening() + getMoodMessageEvening();
    }

    public String getMoodMessageMorning(){
        if(this.mood == 1 || this.mood == 2){
            return "Arvioit mielialasi olevan huono. Huonosti nukuttu yö voi vaikuttaa myös mielialaan. Jokaiselle sattuu myös huonompia päiviä toisinaan. Jos mielialasi jatkuu huonona pitkään yhtäjaksoisesti, hakeudu terveydenhuollon ammattilaisen vastaanotolle. Voit seurata mielialaasi Tarkastele tietoja -osion avulla.";
        }else if(this.mood == 3){
            return "Arvioit mielialasi olevan neutraali. Tarkastele tietojasi -osiosta voita tarkastella mielialaasi pidemmällä aikavälillä. Tapahtuiko mielialassasi muutosta yön aikana?";
        }else if(this.mood == 4 || this.mood == 5){
            return "Arvioit mielialasi olevan hyvä. Oletko havainnut yhteyttä hyvin nukutun yön ja hyvän mielialan välillä?";
        }return "Virhe. Yritä tallentaa tiedot uudelleen.";
    }

    public String getMoodMessageEvening(){
        if(this.mood == 1 || this.mood == 2){
            return "Arvioit mielialasi olevan huono. Huolihetken pitäminen tai rentoutuminen ennen nukkumaanmenoa voi auttaa. Katso tarkempia ohjeita Vinkkejä parempaan uneen -osiosta.";
        }else if(this.mood == 3){
            return "Arvioit mielialasi olevan neutraali. Ilmeisesti mieltäsi ei paina mikään erityisemmin ja olet valmis nukkumaan yösi rauhallisesti.";
        }else if(this.mood == 4 || this.mood == 5){
            return "Arvioit mielialasi olevan hyvä. Hienoa! Mikä tästä päivästä teki erityisen mukavan? Voit kirjata ajatuksiasi ylös ja palata mukaviin muistoihin myöhemmin.";
        }return "Virhe. Yritä tallentaa tiedot uudelleen.";
    }

    public String getTirednessMessageMorning(){
        if(this.tiredness == 1){
            return "Nukuit " + getSleepHrs() + "ja arvioit olevasi väsynyt. Nukuitko mahdollisesti liikaa tai liian vähän? Ole yhteydessä terveydenhuollon ammattilaiseen, jos tunnet olosi jatkuvasti väsyneeksi riittävistä yöunista huolimatta. Tarkastele tietojasi osion avulla voit saada käsityksen montako tuntia sinun tulee nukkua tunteaksesi olosi virkeäksi.\n\n";
        }else if(this.tiredness == 2){
            return "Nukuit " + getSleepHrs() + "ja arvioit olevasi väsynyt. Nukuitko mahdollisesti liikaa tai liian vähän? Ole yhteydessä terveydenhuollon ammattilaiseen, jos tunnet olosi jatkuvasti väsyneeksi riittävistä yöunista huolimatta. Tarkastele tietojasi osion avulla voit saada käsityksen montako tuntia sinun tulee nukkua tunteaksesi olosi virkeäksi.\n\n";
        }else if(this.tiredness == 3){
            return "Nukuit " + getSleepHrs() + "ja arivoit vireystasosi olevan keskitasoa. Syö vielä hyvä aamiainen ja olet valmiina päivän koitoksiin!\n\n";
        }else if(this.tiredness == 4 || this.tiredness == 5){
            return "Nukuit " + getSleepHrs() + "ja arivioit olevasi virkeä. Hienoa! Tästä on hyvä aloittaa uusi päivä!\n\n";
        }return "Virhe. Yritä tallentaa tiedot uudelleen.";
    }

    public String getSleepHrs(){
        if(this.sleptHours == 1){
            return this.sleptHours + " tunnin ";
        }
        return this.sleptHours + " tuntia ";
    }

    public String getTirednessMessageEvening(){
        if(this.tiredness == 1 || this.tiredness == 2){
            return "Arvioit olevasi väsynyt. Ajoittainen väsymys on normaalia. Toivottavasti saat nukuttua hyvin ja tunnet olosi virkeäksi aamulla! Nyt siis kipin kapin unten maille!\n\n";
        }else if(this.tiredness == 3){
            return "Arvioit virkeytesi olevan keskitasoa. Ehkäpä voit vielä valita jotakin rauhallista tekemistä ennen nukkumaanmenoa. Mene vuoteeseen vasta, kun tunnet olosi väsyneeksi.\n\n"; //jotakin lisää?
        }else if(this.tiredness == 4 || this.tiredness == 5){
            return "Arvioit olevasi virkeä. Mukavaa, että päivä ei ole ollut liian rasittava. Jos koet olosi jatkuvasti ylivirittyneeksi iltaisin, katso lisää tietoa Vinkkejä parempaan uneen -osiosta. Esimerkiksi raskasta liikuntaa ja kofeiinia kannattaa välttää ennen nukkumaanmenoa. \n\n";
        }return "Virhe. Yritä tallentaa tiedot uudelleen.";
    }

    public String getSleepHrsMessage(){
        if(this.sleptHours >= 0 && this.sleptHours < 7){
            return "Aikuisen keskiverto unentarve on 7-9 tuntia. Nukuit vähemmän. Jos tunnet olosi virkeäksi, voi olla että pärjäät keskivertoa vähemmällä unella. Voit tarkastella tietojasi pidemmältä aikaväliltä Tarkastele tietoja -osiosta.\n\n";
        }else if(this.sleptHours > 6 && this.sleptHours < 10){
            return "Nukuit sopivasti aikuisen keskivertoon unentarpeeseen verrattuna. Omia keskiarvojasi voit tutkia Tarkastele tietojasi -osiosta.\n\n";
        }else if(this.sleptHours > 9){
            return "Aikuisen keskiverto unentarve on 7-9 tuntia. Nukuit yli yhdeksän tuntia. Liian pitkät yöunet voivat saada olosi tuntumaan väsyneelle. Jos nukut jatkuvasti hyvin pitkiä yöunia, lue lisää tietoa liikaunisuudesta Vinkkejä parempaan uneen -osiosta.\n\n";
        }return "Virhe. Yritä tallentaa tiedot uudelleen.";
    }
}

