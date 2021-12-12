package com.eveliinaheino.peippo;

/**
 * Luokka sisältää konstruktorin ja metodit vinkkien otsikoiden luomista varten.
 * @author Katja
 */
public class TipTitle {
    private String name;
    private String description;
    private Integer picture;

    public TipTitle(String name, String description, Integer picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() { return this.name; }

    public String getDescription(){
        return this.description;
    }

    public Integer getPicture() { return this.picture; }
}
