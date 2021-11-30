package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityFeedbackBeforeSleep extends AppCompatActivity {
    ArrayList <PeippoVariables> list;
    int mood;
    int tiredness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_before_sleep);

        TextView textViewMood = findViewById(R.id.textViewMoodFeedback);
        TextView textViewTiredness = findViewById(R.id.textViewTirednessFeedback);

        list = SingletonMoodsAndTiredness.getInstance().getList();

        mood = list.get(list.size() - 1).getMood();
        tiredness = list.get(list.size() - 1).getTiredness();

        GetFeedbackMessage messages = new GetFeedbackMessage(mood,tiredness);
        textViewMood.setText(messages.getMoodMessage());
        textViewTiredness.setText(messages.getTirednessMessage());

    }
}