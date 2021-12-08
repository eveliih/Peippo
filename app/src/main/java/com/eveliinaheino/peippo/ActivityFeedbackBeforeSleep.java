package com.eveliinaheino.peippo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityFeedbackBeforeSleep extends AppCompatActivity {
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

        TextView textViewEveningFeedback = findViewById(R.id.textViewEveningFeedback);

        list = SingletonPeippoVariablesList.getInstance().getList();

        mood = list.get(list.size() - 1).getMood();
        tiredness = list.get(list.size() - 1).getTiredness();

        GetFeedbackMessage messages = new GetFeedbackMessage(mood,tiredness);
        textViewEveningFeedback.setText(messages.getFeedbackEvening());

    }


    @Override
    protected void onStop() {
        list = SingletonPeippoVariablesList.getInstance().getList();
        super.onStop();
        //halutaanko tallentaa tiedot vasta tässä kohtaa? Nyt tallennus tapahtuu samalla, kun käyttäjä klikkaa Tallenna nappulaa ActivityAddDataBeforeSleep
        /* Gson gson = new Gson();

        String jsonPeippoVariables = gson.toJson(list);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();

        prefEditor.putString("jsonPeippoVariables", jsonPeippoVariables);

        prefEditor.commit(); */

    }

    public void buttonEveningDataCheckClicked(View view){
        Intent intent = new Intent(this, ActivitySeeData.class);
        startActivity(intent);
    }
}