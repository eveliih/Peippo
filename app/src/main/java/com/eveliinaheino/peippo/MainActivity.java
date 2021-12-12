package com.eveliinaheino.peippo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity-luokka jossa tarkastetaan mitä painiketta käyttäjä painaa etusivulta. Avataan sen mukainen aktiviteetti.
 * @author Eveliina
 * @author Hanne
 * @author Katja
 */
public class MainActivity extends AppCompatActivity {
    private String json;
    private ArrayList<PeippoVariables> dataArrayList;

    /**
     * Haetaan SharedPreferenceistä tallennetut arvot sisältävä lista. Jos listaa ei ole, luodaan tyhjä lista. Asetetaan lista Singleton-luokan listaksi.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
        Intent intent = new Intent(this, ActivityTipList.class);
        startActivity(intent);
    }

    /**
     * Tarkastetaan onko käyttäjä tallentanut aikaisempia tietoja ja avataan sen perusteella seuraava aktiviteetti.
     */
    public void buttonSeeDataClicked(View view){
        File file = new File(
                "/data/data/com.eveliinaheino.peippo/shared_prefs/com.eveliinaheino.peippo_preferences.xml");
        if (file.exists()){
            Intent intent = new Intent(this, ActivitySeeData.class);
            startActivity(intent);}
        else {
            Intent intent = new Intent(this, ActivityNoDataSaved.class);
            startActivity(intent);
        }
    }
    public void buttonManualClicked(View view){
        Intent intent = new Intent(this, ActivityManual.class);
        startActivity(intent);
    }
}