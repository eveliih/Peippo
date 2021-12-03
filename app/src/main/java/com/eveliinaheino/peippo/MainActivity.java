package com.eveliinaheino.peippo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
        SharedPreferences prefGet = getPreferences(Context.MODE_PRIVATE);
        String testi = prefGet.getString("Peippo", "oli tyhjä");

        Log.d("testi", testi);

        Intent intent = new Intent(this, ActivityAddDataBeforeSleep.class);
        startActivity(intent);
    }
    public void buttonSeeTipsClicked(View view){
        Intent intent = new Intent(this, ActivityTipList.class);
        startActivity(intent);
    }
    public void buttonSeeDataClicked(View view) {
            Intent intent = new Intent(this, ActivitySeeData.class);
            startActivity(intent);
    }
}