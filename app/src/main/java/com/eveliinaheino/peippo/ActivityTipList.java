package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Luokka luo ListView näkymän. Käyttäjä siirtyy seuraavaan aktiviteettiin painamalla
 * listalta haluamaansa nappia.
 * @author Katja
 */

public class ActivityTipList extends AppCompatActivity {
    private List<String> titles = SingletonTips.getInstance().getTitles();
    private ArrayAdapter<String> tipsAdapter;
    public static final String EXTRATIPS = "com.eveliinaheino.peippo.EXTRATIPS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        final ListView lv = findViewById(R.id.tipsListView);
        this.tipsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titles);
        lv.setAdapter(this.tipsAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent tipActivity = new Intent(ActivityTipList.this, ActivityTipDetails.class);
                tipActivity.putExtra(EXTRATIPS, i);
                startActivity(tipActivity);
            }
        });
    }
}