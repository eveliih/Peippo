package com.eveliinaheino.peippo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * Luokka luo ListView näkymän. Käyttäjä siirtyy seuraavaan aktiviteettiin painamalla
 * listalta haluamaansa nappia.
 * @author Katja
 */

public class ActivityTipList extends AppCompatActivity {
    private ArrayList<TipTitle> tipTitles = SingletonTips.getInstance().getTitles();
    public static final String EXTRATIPS = "com.eveliinaheino.peippo.EXTRATIPS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        final ListView lv = findViewById(R.id.tipsListView);

        CustomBaseAdapter tipsAdapter = new CustomBaseAdapter(
                this,
                tipTitles);

        lv.setAdapter(tipsAdapter);

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