package com.eveliinaheino.peippo;

/**
 * Luokka sisältää konstruktorin ja metodit vinkkien otsikoiden luomista varten.
 * @author Katja
 */
public class TipTitle {
    private String name;
    private String description;

    public TipTitle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
