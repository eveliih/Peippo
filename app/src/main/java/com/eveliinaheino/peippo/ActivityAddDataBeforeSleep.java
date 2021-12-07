package com.eveliinaheino.peippo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityAddDataBeforeSleep extends AppCompatActivity {
    private RadioGroup radioGroupTiredness;
    private RadioGroup radioGroupMood;
    int tiredness;
    int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_before_sleep);

    }

    public void moodRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonMood1:
                if (checked)
                    mood = 1;
                break;
            case R.id.radioButtonMood2:
                if (checked)
                    mood = 2;
                break;
            case R.id.radioButtonMood3:
                if (checked)
                    mood = 3;
                break;
            case R.id.radioButtonMood4:
                if (checked)
                    mood = 4;
                break;

            case R.id.radioButtonMood5:
                if (checked)
                    mood = 5;
                break;
        }
    }
    public void tirednessRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
        case R.id.radioButtonTiredness1:
            if (checked)
                tiredness = 1;
            break;
        case R.id.radioButtonTiredness2:
            if (checked)
                tiredness = 2;
            break;
        case R.id.radioButtonTiredness3:
            if (checked)
                tiredness = 3;
            break;
        case R.id.radioButtonTiredness4:
            if (checked)
                tiredness = 4;
            break;

        case R.id.radioButtonTiredness5:
            if (checked)
                tiredness = 5;
            break;
    }
}

    public void buttonSavedClicked(View view) {

        if (tiredness != 0 && mood != 0) {      //jos molempiin radiobuttoneihin on tehty valinta niin tallennetaan arvot listalle&shared prefrensseihin ja aloitetaan uusi aktiviteetti
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            month++;
            SingletonPeippoVariablesList.getInstance().getList().add(new PeippoVariables(0, tiredness, mood, day, month));
            Intent intent = new Intent(this, ActivityFeedbackBeforeSleep.class);

            Gson gson = new Gson();
            ArrayList<PeippoVariables> list = SingletonPeippoVariablesList.getInstance().getList();

            String jsonPeippoVariables = gson.toJson(list);

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();

            prefEditor.putString("jsonPeippoVariables", jsonPeippoVariables);

            prefEditor.commit();

            startActivity(intent);
        } else {      //jos molempiin radiobuttoneihin ei ole tehty valintaa niin käyttäjälle näytetään viesti, jossa kehotetaan tallentamaan tiedot
            Context context = getApplicationContext();
            CharSequence text = "Täytä kaikki kohdat ennen tallentamista!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}