package com.eveliinaheino.peippo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ActivitySeeData extends AppCompatActivity {
    private CombinedChart peippoChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_data);

        peippoChart = findViewById(R.id.combinedChart);
        peippoChart.getDescription().setText("Viimeisten 7 päivän tiedot");
        peippoChart.setBackgroundColor(Color.WHITE);
        peippoChart.setDrawGridBackground(true);
        peippoChart.setDrawBarShadow(true);
        peippoChart.setHighlightFullBarEnabled(true);


        /* Tällä saa viivat näkymään pylväiden päällä */
        peippoChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR,  CombinedChart.DrawOrder.LINE
        });

        /* Pylväiden ja viivojen selitysmerkkien asettelu */
        Legend legend = peippoChart.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        /* Diagrammin oikealla, vasemmalla ja alapuolella olevat merkinnät */
        YAxis rightAxis = peippoChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setLabelCount(15, true);
        rightAxis.setAxisMaximum(15);

        YAxis leftAxis = peippoChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setLabelCount(15, true);
        leftAxis.setAxisMaximum(15);

        XAxis xAxis = peippoChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        data.setData(generateBarData());

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        peippoChart.setData(data);
        peippoChart.invalidate();
        peippoChart.animateXY(2000, 2000); /* Diagrammin auetessa näkyvä animaatio */
    }

    /* Tästä saa asetettua pylväiden alapuolelle tekstit, esim. viikonpäivät */
    protected String[] labels = new String[] {
            " ", " ", " ", " ", "  ", " "
    };


    /* Tuottaa datan viivadiagrammeihin */
    private LineData generateLineData(){

        /* Tähän asetetaan viivadiagrammien arvot */
        float[] valOne = {2, 3, 5, 2, 5, 4, 1, 3, 6};
        float[] valTwo = {5, 2, 3, 1, 3, 2, 5, 3, 6};

        ArrayList<Entry> lineOne = new ArrayList<>();
        ArrayList<Entry> lineTwo = new ArrayList<>();
        for (int i = 1; i < valOne.length; i++) {
            lineOne.add(new Entry(i, valOne[i]));
            lineTwo.add(new Entry(i, valTwo[i]));
        }

        LineDataSet set1 = new LineDataSet(lineOne, "Virkeys (1-5)");
        set1.setColor(Color.rgb(60, 220, 100));
        LineDataSet set2 = new LineDataSet(lineTwo, "Mieliala (1-5)");
        set2.setColor(Color.rgb(220, 100, 60));

        set1.setLineWidth(2f);
        set1.setCircleColor(Color.rgb(60, 220, 100));
        set1.setCircleRadius(3f);
        set1.setFillColor(Color.rgb(60, 220, 100));
        set1.setMode(LineDataSet.Mode.LINEAR);
        set1.setDrawValues(false);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.BLACK);

        set2.setLineWidth(2f);
        set2.setCircleColor(Color.rgb(220, 100, 60));
        set2.setCircleRadius(3f);
        set2.setFillColor(Color.rgb(220, 100, 60));
        set2.setMode(LineDataSet.Mode.LINEAR);
        set2.setDrawValues(false);
        set2.setValueTextSize(10f);
        set2.setValueTextColor(Color.BLACK);

        set1.setHighlightEnabled(false);
        set2.setHighlightEnabled(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);

        LineData linedata = new LineData(dataSets);

        return linedata;
    }

    /* Tuottaa datan pylväsdiagrammiin */

    private BarData generateBarData() {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        entries = getBarEnteries(entries);

        BarDataSet set1 = new BarDataSet(entries, "Uni (tuntia)");
        set1.setColor(Color.rgb(60, 100, 220));
        // set1.setColors(ColorTemplate.JOYFUL_COLORS) /* Jos haluaa eriväriset pylväät */
        set1.setValueTextColor(Color.BLACK);
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        float barWidth = 0.8f; // x2 dataset

        BarData bardata = new BarData(set1);
        bardata.setBarWidth(barWidth);

        return bardata;
    }

    /* Asettaa arvot pylväsdiagrammiin */
    private ArrayList<BarEntry> getBarEnteries(ArrayList<BarEntry> entries){

        /* Pylväsdiagrammin arvot */
        float[] value = {7, 10, 8, 11, 6, 7, 8, 9};

        for (int i = 1; i < value.length; i++) {
            entries.add(new BarEntry(i, value[i]));
        }
        return  entries;
    }
}