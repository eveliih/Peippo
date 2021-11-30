package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityTipDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(ActivitySeeTips.EXTRATIPS, 0);

        ((TextView)findViewById(R.id.textViewTitle))
                .setText("Otsikko");
        ((TextView)findViewById(R.id.textViewTip))
                .setText(TipText.getTipText(i));
    }
}