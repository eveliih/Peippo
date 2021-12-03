package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonAddAfterSleepClicked(View view){
        Intent intent = new Intent(this, ActivityAddDataAfterSleep.class);
        startActivity(intent);
    }
    public void buttonAddBeforeSleepClicked(View view){
        Intent intent = new Intent(this, ActivityAddDataBeforeSleep.class);
        startActivity(intent);
    }
    public void buttonSeeTipsClicked(View view){
        Intent intent = new Intent(this, ActivityTipList.class);
        startActivity(intent);
    }
}