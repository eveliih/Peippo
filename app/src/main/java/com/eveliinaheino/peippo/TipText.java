package com.eveliinaheino.peippo;

public class TipText {

    public TipText() {
    }

    public static String getText(int i){
        if (i == 0) {
            return "moi";
        } else if (i == 1) {
            return "hei";
        } else if (i == 2){
            return "hi";
        } else if (i == 3){
            return "hello";
        } else if (i == 4){
            return "hey";
        } else {
            return "ey";
        }
    }
}
