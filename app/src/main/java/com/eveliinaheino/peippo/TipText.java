package com.eveliinaheino.peippo;

public class TipText {

    public TipText() {
    }

    public static String getTipText(int i){
        if (i == 0) {
            return "Unen saantiin vaikuttavat monet arkiset asiat ja tavat. Ensimmäiseksi on hyvä tarkastaa " +
                    "kofeiinin, nikotiinin ja alkoholin käyttö, ruokavalion laatu ja liikunnan määrä. " +
                    "Sosiaalisista suhteista ja hauskanpidosta huolehtiminen voivat edistää mielen " +
                    "hyvinvointia ja tämän välityksellä parantaa unen laatua.\n" +
                    "\n" +
                    "Myöhäinen ilta on hyvä rauhoittaa, jotta keho ei ole virittyneessä tilassa sänkyyn " +
                    "mentäessä. Raskasta liikuntaa on hyvä välttää neljä tuntia ennen nukkumaanmenoa, mutta " +
                    "kevyt kävely tai venyttely voi auttaa saamaan unen päästä kiinni. Iltarutiini, joka " +
                    "kestää noin 60-90 minuuttia ennen nukkumaanmenoa, viestii keholle, että kohta on " +
                    "aika mennä nukkumaan. Rutiiniin voi kuulua rauhoittavaa ja rentouttavaa tekemistä, " +
                    "kuten lukemista, kevyt iltapala ja iltatoimet. Toimiakseen rutiinin on toistuttava " +
                    "päivittäin samankaltaisena.\n" +
                    "\n" +
                    "Uniongelmat voivat johtua myös liian vähäisestä tekemisestä. Jos päivään kuuluu " +
                    "paljon istumista eikä erityisemmin liikuntaa, saattaa passiivisuus vaikeuttaa nukahtamista." +
                    "Liikunnan on todettu vaikuttavan nukahtamiseen ja lisäävän palauttavan, syvän unen määrää.";
        } else if (i == 1) {
            return "hei";
        } else if (i == 2){
            return "hi";
        } else if (i == 3){
            return "hello";
        } else if (i == 4){
            return "hey";
        } else {
            return "heyo";
        }
    }
}
