package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Aktiviteetti-luokka, joka näyttää SingletonTips-luokan sisältämiä tekstejä
 * käyttäjän TipList-aktiviteetissa tekemän valinnan mukaan.
 * @author Katja
 */

public class ActivityTipDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(ActivityTipList.EXTRATIPS, 0);

        ((TextView)findViewById(R.id.textViewTitle))
                .setText(SingletonTips.getInstance().getTitle(i));
        ((TextView)findViewById(R.id.textViewTip))
                .setText(SingletonTips.getInstance().getTexts(i));
    }
}