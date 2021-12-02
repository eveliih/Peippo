package com.eveliinaheino.peippo;

import java.util.ArrayList;

public class SingletonMoodsAndTiredness{
    private static final SingletonMoodsAndTiredness ourInstance = new SingletonMoodsAndTiredness();
    private ArrayList<PeippoVariables> peippoVariablesArrayList;

    public static SingletonMoodsAndTiredness getInstance() {
        return ourInstance;
    }

    private SingletonMoodsAndTiredness() {
        this.peippoVariablesArrayList = new ArrayList<>();
    }
    public ArrayList<PeippoVariables> getList(){
        return this.peippoVariablesArrayList;
    }
}
