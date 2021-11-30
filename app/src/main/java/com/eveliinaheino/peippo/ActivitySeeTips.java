package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivitySeeTips extends AppCompatActivity {
    private static List<String> titles = new ArrayList<>();
    private ArrayAdapter<String> tipsAdapter;
    public static final String EXTRATIPS = "com.eveliinaheino.peippo.EXTRATIPS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_tips);

        titles.add("Elämäntavat");
        titles.add("Nukkumisympäristö");
        titles.add("Vuoteessa olo");
        titles.add("Rentoutus");
        titles.add("Tietoinen läsnäolo");
        titles.add("Kognitiiviset menetelmät");

        final ListView lv = findViewById(R.id.tipsListView);
        this.tipsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titles);
        lv.setAdapter(this.tipsAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent tipActivity = new Intent(ActivitySeeTips.this, ActivityTipDetails.class);
                tipActivity.putExtra(EXTRATIPS, i);
                startActivity(tipActivity);
            }
        });
    }

    public static String getTipTitle(int i){
        return titles.get(i);
    }
}