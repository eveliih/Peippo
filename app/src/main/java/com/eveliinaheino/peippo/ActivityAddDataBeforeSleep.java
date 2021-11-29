package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

    public void buttonSavedClicked(View view){
        SingletonMoodsAndTiredness.getInstance().getList().add(new TirednessAndMood(tiredness, mood));
        Intent intent = new Intent(this, ActivityFeedbackBeforeSleep.class);
        startActivity(intent);
    }
}