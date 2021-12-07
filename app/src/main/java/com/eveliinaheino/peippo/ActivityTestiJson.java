package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityTestiJson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testi_json);

        TextView textView = findViewById(R.id.textViewJson);
        ArrayList<PeippoVariables> peippoList = SingletonPeippoVariablesList.getInstance().getList();

        textView.setText("Viimeisin tallennettu mieliala: " + Integer.toString(peippoList.get(peippoList.size()-1).getMood())); //testinä haetaan listan viimeisestä oliosta mielialan arvo

    }
}