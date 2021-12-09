package com.eveliinaheino.peippo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Aktiviteetti-luokka, joka näyttää käyttäjälle sovelluksen käyttöohjeet pop up-ikkunassa.
 * Ok-nappulaa klikatessa palataan etusivulle.
 * @author Eveliina
 */
public class ActivityManual extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.5)); //määritellään pop up ikkunan koko

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER; //määritellään pop up ikkunan sijainti
        params.x = 0;
        params.y = -10;

        getWindow().setAttributes(params);
    }
    public void buttonOkClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}