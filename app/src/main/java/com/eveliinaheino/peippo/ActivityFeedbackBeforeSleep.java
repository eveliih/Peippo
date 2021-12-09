package com.eveliinaheino.peippo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * Aktiviteetti-luokka, jossa haetaan käyttäjän illalla syöttämien arvojen perusteella arvojen mukainen palaute, joka näytetään käyttäjälle.
 * Käyttäjän klikatessa Tarkastele tietojasi-nappulaa, siirrytään toiseen aktiviteettiin.
 * @author Eveliina
 */
public class ActivityFeedbackBeforeSleep extends AppCompatActivity {
    private ArrayList <PeippoVariables> list;
    private int mood;
    private int tiredness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_before_sleep);

        TextView textViewEveningFeedback = findViewById(R.id.textViewEveningFeedback);

        list = SingletonPeippoVariablesList.getInstance().getList();

        mood = list.get(list.size() - 1).getMood();
        tiredness = list.get(list.size() - 1).getTiredness();

        GetFeedbackMessage messages = new GetFeedbackMessage(mood,tiredness);
        textViewEveningFeedback.setText(messages.getFeedbackEvening());

    }

    public void buttonEveningDataCheckClicked(View view){
        Intent intent = new Intent(this, ActivitySeeData.class);
        startActivity(intent);
    }
}