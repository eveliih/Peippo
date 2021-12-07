package com.eveliinaheino.peippo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Luokka kertoo käyttäjälle, ettei tietoja ole syötetty, jos tämä yrittää avata diagrammia ennen
 * tietojen syöttämistä.
 * @author hanne
 */

public class ActivityNoDataSaved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_data_saved);
        TextView tv = findViewById(R.id.textView);
        String message = "Et ole vielä syöttänyt tietoja";
        tv.setText(message);
    }


    public void buttonAddAfterSleepClicked(View view) {
        Intent intent = new Intent(this, ActivityAddDataAfterSleep.class);
        startActivity(intent);
    }

    public void buttonAddBeforeSleepClicked(View view) {
        Intent intent = new Intent(this, ActivityAddDataBeforeSleep.class);
        startActivity(intent);
    }
}