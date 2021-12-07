package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String json;
    ArrayList<PeippoVariables> dataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); //pitää olla näin eikä, jotta eri aktiviteetissa tallennettuja tietoja voidaan lukea täällä
        json = prefGet.getString("jsonPeippoVariables", " ");


        if(json.equals(" ")){
            dataArrayList = new ArrayList<>();
        }
        else{
            Gson gson = new Gson();
            TypeToken<List<PeippoVariables>> token = new TypeToken<List<PeippoVariables>>() {};
            List<PeippoVariables> dataList = gson.fromJson(json, token.getType());
            dataArrayList = new ArrayList<>(dataList.size());
            dataArrayList.addAll(dataList);
        }

        SingletonPeippoVariablesList.getInstance().setArrayListToSingleton(dataArrayList);

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
        Intent intent = new Intent(this, ActivitySeeTips.class);
        startActivity(intent);
    }
    public void buttonSeeDataClicked(View view){
        Intent intent = new Intent(this, ActivityTestiJson.class);
        startActivity(intent);
    }
}