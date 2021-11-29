package com.eveliinaheino.peippo;

import java.util.ArrayList;
import java.util.List;

public class SingletonMoodsAndTiredness {
    private static final SingletonMoodsAndTiredness ourInstance = new SingletonMoodsAndTiredness();
    private ArrayList<TirednessAndMood> listTirednessAndMoods = new ArrayList();

    public static SingletonMoodsAndTiredness getInstance() {
        return ourInstance;
    }

    private SingletonMoodsAndTiredness(){
        this.listTirednessAndMoods = new ArrayList<TirednessAndMood>();
    }
    public ArrayList<TirednessAndMood> getList(){
        return this.listTirednessAndMoods;
    }
}
