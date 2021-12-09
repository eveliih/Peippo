package com.eveliinaheino.peippo;

import java.util.ArrayList;

/**
 * Singleton luokka joka sisältää PeippoVariables-olioista koostuvan listan.
 * @author Eveliina
 */

public class SingletonPeippoVariablesList {
    private static final SingletonPeippoVariablesList ourInstance = new SingletonPeippoVariablesList();
    private ArrayList<PeippoVariables> peippoVariablesArrayList;

    public static SingletonPeippoVariablesList getInstance() {
        return ourInstance;
    }

    private SingletonPeippoVariablesList() {
       this.peippoVariablesArrayList = new ArrayList<>();
    }

    public ArrayList<PeippoVariables> getList(){
        return this.peippoVariablesArrayList;
    }

    /**
     * Metodille annetaan parametrina ArrayList, joka halutaan asettaa this.peippoVariablesArrayList:iksi.
     * Käytetään asettamaan SharedPreferenceistä haettu lista Singletonin listaksi.
     * @param sharedPreferencesArrayList
     */
    public void setArrayListToSingleton(ArrayList sharedPreferencesArrayList){
        this.peippoVariablesArrayList = sharedPreferencesArrayList;
    }

}
