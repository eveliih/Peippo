package com.eveliinaheino.peippo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Luokka avautuu, mikäli käyttäjä yrittää avata diagrammia, ennen kuin on syöttänyt sovellukseen
 * ollenkaan tietoja.
 * @author Hanne
 */

public class ActivityNoDataSaved extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_data_saved);
        TextView tv = findViewById(R.id.textView);
        String message = "Et ole vielä syöttänyt tietoja";
        tv.setText(message);
    }

    public void buttonAddAfterSleepClicked(View view) {
        super.buttonAddAfterSleepClicked(view);
    }

    public void buttonAddBeforeSleepClicked(View view) {
        super.buttonAddBeforeSleepClicked(view);
    }
}