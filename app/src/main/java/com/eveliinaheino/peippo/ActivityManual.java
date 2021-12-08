package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class ActivityManual extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        DisplayMetrics displayMetrics = new DisplayMetrics(); //tulevalla jutulla tehdään Activitystä popup ikkuna
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes(); //tällä asetetaan popup ikkunan sijainti
        params.gravity = Gravity.CENTER;
        params.x = 0; //keskellä
        params.y = -10;

        getWindow().setAttributes(params);
    }
    public void buttonOkClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}