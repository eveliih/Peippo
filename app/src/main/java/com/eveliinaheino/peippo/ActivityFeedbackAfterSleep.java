package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Aktiviteetti-luokka,jossa haetaan käyttäjän aamulla syöttämien arvojen perusteella arvojen mukainen palaute, joka näytetään käyttäjälle.
 * Käyttäjän klikatessa Tarkastele tietojasi-nappulaa, siirrytään toiseen aktiviteettiin.
 * @author Eveliina
 */
public class ActivityFeedbackAfterSleep extends AppCompatActivity {
   private ArrayList<PeippoVariables> list;
   private int mood;
   private int tiredness;
   private int sleptHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_after_sleep);
        TextView textViewMood = findViewById(R.id.textViewMorningFeedback);

        list = SingletonPeippoVariablesList.getInstance().getList();
        mood = list.get(list.size() - 1).getMood();
        tiredness = list.get(list.size() - 1).getTiredness();
        sleptHours = list.get(list.size() - 1).getSleptHours();

        GetFeedbackMessage getFeedbackMessage = new GetFeedbackMessage(mood, tiredness, sleptHours);

        textViewMood.setText(getFeedbackMessage.getFeedbackMorning());

    }

    public void buttonMorningDataCheckClicked(View view){
        Intent intent = new Intent(this, ActivitySeeData.class);
        startActivity(intent);
    }
}