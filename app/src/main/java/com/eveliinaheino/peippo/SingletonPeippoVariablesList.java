package com.eveliinaheino.peippo;

import java.util.ArrayList;

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

    public void setArrayListToSingleton(ArrayList arrayList){
        this.peippoVariablesArrayList = arrayList;
    }

}
