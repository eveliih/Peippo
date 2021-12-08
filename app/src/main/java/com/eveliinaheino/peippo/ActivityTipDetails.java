package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityTipDetails extends AppCompatActivity {
    private ArrayList<String> titles;
    private ArrayList<String> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);

        titles = SingletonTips.getInstance().getTitles();
        texts = SingletonTips.getInstance().getTexts();

        Bundle b = getIntent().getExtras();
        int i = b.getInt(ActivityTipList.EXTRATIPS, 0);

        ((TextView)findViewById(R.id.textViewTitle))
                .setText(titles.get(i));
        ((TextView)findViewById(R.id.textViewTip))
                .setText(texts.get(i));
    }
}