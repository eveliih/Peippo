package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityFeedbackAfterSleep extends AppCompatActivity {
    ArrayList<PeippoVariables> list;
    int mood;
    int tiredness;
    int sleptHours;

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
}