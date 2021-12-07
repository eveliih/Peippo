package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityManual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
    }
    public void buttonOkClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}