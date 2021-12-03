package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ActivityAddDataAfterSleep extends AppCompatActivity {
    private RadioGroup radioGroupTiredness;
    private RadioGroup radioGroupMood;
    int tiredness;
    int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_after_sleep);
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

    public void buttonSavedClicked(View view){
        EditText editTextSleptHours = findViewById(R.id.editTextSleepHours);

        Intent intent = new Intent(this, ActivityFeedbackAfterSleep.class);

        if(tiredness != 0 && mood !=0 && !(editTextSleptHours.getText().toString().isEmpty())){ //jos kaikki pyydetyty tiedot on annettu niin tallennetaan tiedot ja aloitetaan uusi aktiviteetti
            int sleptHrs = Integer.parseInt(editTextSleptHours.getText().toString());
            SingletonMoodsAndTiredness.getInstance().getList().add(new PeippoVariables(1, tiredness, mood, sleptHrs));

            //halutaanko tallentaa tässä vai myöhemmin?
            Gson gson = new Gson();
            ArrayList<PeippoVariables> list = SingletonMoodsAndTiredness.getInstance().getList();

            String jsonPeippoVariables = gson.toJson(list);

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();

            prefEditor.putString("jsonPeippoVariables", jsonPeippoVariables);

            prefEditor.commit();

            startActivity(intent);
        }
        else{ //jos valintaa ei ole tehty näytetään käyttäjälle viesti
            Context context = getApplicationContext();
            CharSequence text = "Täytä kaikki kohdat ennen tallentamista!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}