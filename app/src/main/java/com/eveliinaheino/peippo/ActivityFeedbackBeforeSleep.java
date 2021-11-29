package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityFeedbackBeforeSleep extends AppCompatActivity {
    ArrayList <TirednessAndMood> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_before_sleep);

        TextView textViewMood = findViewById(R.id.textViewMoodFeedback);
        TextView textViewTiredness = findViewById(R.id.textViewTirednessFeedback);

        list = SingletonMoodsAndTiredness.getInstance().getList();
        int mood = list.get(list.size() -1).getMood();
        int tiredness = list.get(list.size() - 1).getTiredness();

        textViewMood.setText(Integer.toString(mood));
        textViewTiredness.setText(Integer.toString(tiredness));
    }
}