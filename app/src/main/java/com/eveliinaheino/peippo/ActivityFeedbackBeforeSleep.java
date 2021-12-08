package com.eveliinaheino.peippo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityFeedbackBeforeSleep extends AppCompatActivity{
    ArrayList <PeippoVariables> list;
    int mood;
    int tiredness;


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
}