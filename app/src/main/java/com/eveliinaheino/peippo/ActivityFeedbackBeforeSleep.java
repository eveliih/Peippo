package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ActivityFeedbackBeforeSleep extends Activity{
    ArrayList <PeippoVariables> list;
    int mood;
    int tiredness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_before_sleep);
        //testailin tehdä tästä popup ikkunaa, mutta yllätys yllätys siitä koitui kaikenlaisia haasteita xD Jätän nää nyt vielä tähän, jos jää aika tutkailla tätä
       /* DisplayMetrics displayMetrics = new DisplayMetrics(); //tulevalla jutulla tehdään Activitystä popup ikkuna
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes(); //tällä asetetaan popup ikkunan sijainti
        params.gravity = Gravity.CENTER;
        params.x = 0; //keskellä
        params.y = -20;

        getWindow().setAttributes(params);*/

        TextView textViewMood = findViewById(R.id.textViewMoodFeedback);
        TextView textViewTiredness = findViewById(R.id.textViewTirednessFeedback);

        list = SingletonMoodsAndTiredness.getInstance().getList();

        mood = list.get(list.size() - 1).getMood();
        tiredness = list.get(list.size() - 1).getTiredness();

        GetFeedbackMessage messages = new GetFeedbackMessage(mood,tiredness);
        textViewMood.setText(messages.getMoodMessage());
        textViewTiredness.setText(messages.getTirednessMessage());


    }


    @Override
    protected void onStop() {
        list = SingletonMoodsAndTiredness.getInstance().getList();
        super.onStop();
        //halutaanko tallentaa tiedot vasta tässä kohtaa? Nyt tallennus tapahtuu samalla, kun käyttäjä klikkaa Tallenna nappulaa ActivityAddDataBeforeSleep
        /* Gson gson = new Gson();

        String jsonPeippoVariables = gson.toJson(list);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();

        prefEditor.putString("jsonPeippoVariables", jsonPeippoVariables);

        prefEditor.commit(); */

    }

}