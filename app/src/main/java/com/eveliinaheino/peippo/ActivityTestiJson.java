package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ActivityTestiJson extends AppCompatActivity {
    ArrayList<PeippoVariables> data;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testi_json);

        SharedPreferences prefGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); //pitää olla näin eikä, jotta eri aktiviteetissa tallennettuja tietoja voidaan lukea täällä
        json = prefGet.getString("jsonPeippoVariables", " ");

        TextView textView = findViewById(R.id.textViewJson);

        Gson gson = new Gson();
        TypeToken<List<PeippoVariables>> token = new TypeToken<List<PeippoVariables>>() {};
        List<PeippoVariables> peippoList = gson.fromJson(json, token.getType());

        textView.setText("Viimeisin tallennettu mieliala: " + Integer.toString(peippoList.get(peippoList.size()-1).getMood())); //testinä haetaan listan viimeisestä oliosta mielialan arvo

       /*
        //jos tarvitsee tehdä ArrayList Listasta niin voi tehdä näin. Ei pitäisi kai olla tarpeen, koska tietojen tarkasteluvaiheessa ei samanaikaisesti lisätä mitään
        ArrayList<PeippoVariables> peippoArrayList = new ArrayList<>(peippoList.size());
        peippoArrayList.addAll(peippoList);

        */


    }
}