package com.eveliinaheino.peippo;

import java.util.ArrayList;

public class SingletonTips {
    private static final SingletonTips ourInstance = new SingletonTips();
    private ArrayList<String> tipTitles;
    private ArrayList<String> tipTexts;

    public static SingletonTips getInstance() {
        return ourInstance;
    }

    private SingletonTips() {
        this.tipTitles = new ArrayList<>();
        this.tipTexts = new ArrayList<>();
        tipTitles.add("Elämäntavat");
        tipTitles.add("Nukkumisympäristö");
        tipTitles.add("Vuoteeseen meno");
        tipTitles.add("Rentoutus");
        tipTitles.add("Tietoinen läsnäolo");
        tipTitles.add("Kognitiiviset menetelmät");
        tipTitles.add("Liikaunisuus");
        tipTexts.add("Unen saantiin vaikuttavat monet arkiset asiat ja tavat. Ensimmäiseksi on hyvä tarkastaa " +
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
                "Liikunnan on todettu vaikuttavan nukahtamiseen ja lisäävän palauttavan, syvän unen määrää.\n" +
                "\n" +
                "Lähde: Mielenterveystalo, Unettomuuden omahoito");
        tipTexts.add("Tuuletettussa ja viileässa (18-21 astetta) huoneessa on helpompi nukahtaa. " +
                "Nukkumaan mennessä ja yön aikana huoneen olisi hyvä olla pimeä, mutta " +
                "aamulla valoisa. Esimerkiksi kirkasvalolampulla saa pimeään vuodenaikaan valoa, jota " +
                "ei muuten ole tarjolla. Valon määrän vaihtelu tukee vuorokausirytmiä.\n" +
                "\n" +
                "Siistissä ja kodikkaassa huoneessa on helpompi nukahtaa kuin sekaisessa ja epämukavassa." +
                "Jos huone on kovin sekaisessa kunnossa, sen siivoamiseen kannattaa käyttää hieman aikaa. " +
                "Mikäli käytössä on erillinen makuuhuone, niin sen varaaminen vain nukkumiseen ja rakasteluun " +
                "voi auttaa lisäämään yhteyttä makuuhuoneen ja nukkumisen välillä.\n" +
                "\n" +
                "Mukava ja kehollesi sopiva vuode on tärkeä hyvän unen saavuttamiseksi. Sopivan patjan " +
                "ja tyynyn valintaan kannattaa kiinnittää huomiota.\n" +
                "\n" +
                "Lähde: Mielenterveystalo, Unettomuuden omahoito");
        tipTexts.add("Vuoteeseen tulisi mennä vain väsyneenä. Vuoteen ja unen välille voi rakentaa vahvan " +
                "yhteyden käyttämällä vuodetta vain nukkumiseen ja mahdollisesti rakasteluun. Yhteys auttaa" +
                "kehoa ymmärtämään, että nyt on tarkoitus nukkua. Vuoteessa ei tulisi esimerkiksi lukea, " +
                "syödä, selata puhelinta tai katsoa televisiota. Erityisesti elektroniikan, kuten kännykän " +
                "tai television, valo stimuloi aivoja ja estää unihormoni melatoniinin erittymistä. " +
                "Valot tulisi sammuttaa heti vuoteeseen mentäessä.\n" +
                "\n" +
                "Jos uni ei tule puolessa tunnissa, vuoteesta tulisi nousta ylös, jottei vuoteen ja valveen " +
                "välille syntyisi yhteyttä. Monesti vuoteessa oloon saattaa liittyä myös kärsimystä tai " +
                "ahdistusta, koska uni ei tule, mikä omalta osaltaan vaikeuttaa nukahtamista. Ylös nouseminen ja " +
                "tuolille tai toiseen huoneeseen siirtyminen auttavat ehkäisemään näiden mielleyhtymien syntyä. " +
                "Vuoteeseen voi palata, kun tuntee olonsa taas uneliaaksi.\n" +
                "\n" +
                "Lähde: Mielenterveystalo, Unettomuuden omahoito");
        tipTexts.add("Rentoutus on tutkitusti tehokas keino unettomuuden hoitoon. Eniten tutkimustietoa on " +
                "progressiivisesta rentoutuksesta, jossa jännitetään ja rentoutetaan kehon lihasryhmiä " +
                "vuoron perään. Tarkoituksena on oppia tuntemaan kehon jännitystiloja ja oppia " +
                "rentouttamaan keho tietoisesti. Äänitteitä ohjattuun lihasrentoutukseen löytyy vaikkapa " +
                "Mielenterveystalon sivuilta.\n" +
                "\n" +
                "Myös hengitysharjoitukset auttavat rentoutumaan. Yksinkertaisimmillaan harjoitus voi olla " +
                "asettumista makuuasentoon ja syvään hengittämistä. Kädet laitetaan vatsan päälle ja pyritään " +
                "hengittämään vatsalla niin, että kädet liikkuvat ylös alas vatsan mukana. Hengitystahti on " +
                "syvä ja rauhallinen, ja jokaisen uloshengityksen jälkeen pidetään parin sekunnin tauko ennen " +
                "seuraavaa sisäänhengitystä. Keho päästetään tietoisesti rentoutumaan hengittelyn aikana.\n" +
                "\n" +
                "On olemassa monia tapoja rentoutua. Jos yksi tapa tuntuu epämukavalta, kannattaa " +
                "antaa mahdollisuus toiselle tekniikalle. Internetistä löytyy valtavasti erilaisia ohjattuja " +
                "harjoituksia ja äänitteitä.\n" +
                "\n" +
                "Lähde: Mielenterveystalo, Unettomuuden omahoito");
        tipTexts.add("Tietoisesta läsnäolosta puhuttaessa tarkoitetaan omien tunteiden, ajatuksien ja kokemuksien " +
                "huomiomista tuomitsematta ja arvottamatta niitä. Tarkoituksena on oppia huomiomaan " +
                "omat kokemukset objektiivisesti tilanteissa, jossa ne syntyvät. Asioiden vain todetaan olevan " +
                "tietyllä tavalla ilman niiden arvottamista positiivisiksi tai negatiivisiksi. Lopuksi " +
                "hyväksytään tapahtuma ja kokemus sellaisena kuin se on.\n" +
                "\n" +
                "Tietoisen läsnäolon taito voi auttaa nukahtamaan. Nukahtamattomuutta ei tarvitse enää tuomita " +
                "vaan voi tarkastella tilannetta lempeästi ja sallivasti harmistumisen tai " +
                "ahdistumisen sijaan. On tärkeää harjoitella taitoa helpoissa tilanteissa päiväsaikaan " +
                "ennen kuin rupeaa käyttämään sitä illalla tai yöllä nukahtamisen apuna. Näin taidon mahdollinen " +
                "harjoituksen puutteesta johtuva toimimattomuus ei ala harmittaa.\n" +
                "\n" +
                "Lähde: Mielenterveystalo; Unettomuuden omahoito");
        tipTexts.add("Joskus nukahtamisen apuna voi käyttää mielen tiedonkäsittelyyn vaikuttavia tekniikoita, " +
                "joita voivat olla esimerkiksi huolihetken pitäminen ennen nukkumaan menoa, " +
                "liiallisesta nukkumisen yrittämisestä luopuminen ja mielessä pyörivien ajatusten pysäyttäminen " +
                "merkityksettömän pysäytyssanan avulla. Näille tekniikoille on yhteistä vähentää mielen " +
                "vireystilaa, jotta nukahtaminen ja unessa pysyminen olisi helpompaa.\n" +
                "\n" +
                "Tarkemmat tekniikoiden suoritusohjeet löytyvät Mielenterveystalon Unettomuuden omahoito " +
                "-ohjelman osiosta Irti unettomuudesta.\n" +
                "\n" +
                "Lähde: Mielenterveystalo, Unettomuuden omahoito");
        tipTexts.add("Jatkuvasta yli yhdeksän tunnin unentarpeesta tai poikkeavasta päiväaikaisesta väsymyksestä ja " +
                "nukahtelutaipumuksesta puhutaan liikaunisuutena. Nukahtelutaipumus näyttäytyy torkahteluna " +
                "useimmiten passiivisissa tilanteissa, jolloin henkilö ei ole fyysisesti aktiivinen. " +
                "Harvoin torkahtelua tapahtuu myös aktiivisissa tilanteissa. Useimmiten liikaunisuuden syyt " +
                "johtuvat elämäntilanteesta tai elintavoista, mutta mahdollisten sairauksien poissulkemiseksi " +
                "on hyvä käydä selvittämässä syy lääkärin vastaanotolla.\n" +
                "\n" +
                "Hoitoon tulee hakeutua, jos liikaunisuus on alkanut äkillisesti, se ilmenee päiväaikaisena " +
                "nukahtelutaipumuksena tai haittaa tavallista elämää, opiskelua tai työntekoa. Tutkimuksiin " +
                "tulee hakeutua myös siinä tapauksessa, että liikaunisuuteen liittyy muita oireita, kuten " +
                "laihtumista, ruokahaluttomuutta tai katapleksiaa, jolla tarkoitetaan tunne-elämysten yhteydessä " +
                "tapahtuvaa lihaskontrollin menettämistä.\n" +
                "\n" +
                "Jos liikaunisuuden taustalla ei ole todettu erityistä sairautta, voi yöunen laadun parantaminen " +
                "vähentää suurta unen tarvetta tai päiväaikaista väsymystä torkahtelutaipumuksineen.\n" +
                "\n" +
                "Lähde: Terveyskirjasto, Liikaunisuus");
    }

    public ArrayList<String> getTitles(){
        return this.tipTitles;
    }
    public ArrayList<String> getTexts() { return this.tipTexts; }
}

