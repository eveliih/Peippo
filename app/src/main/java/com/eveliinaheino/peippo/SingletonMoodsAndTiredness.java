package com.eveliinaheino.peippo;

import java.util.ArrayList;

public class SingletonMoodsAndTiredness {
    private static final SingletonMoodsAndTiredness ourInstance = new SingletonMoodsAndTiredness();
    private ArrayList<PeippoVariables> listPeippoVariables = new ArrayList();

    public static SingletonMoodsAndTiredness getInstance() {
        return ourInstance;
    }

    private SingletonMoodsAndTiredness(){
        this.listPeippoVariables = new ArrayList<PeippoVariables>();
    }
    public ArrayList<PeippoVariables> getList(){
        return this.listPeippoVariables;
    }
}
