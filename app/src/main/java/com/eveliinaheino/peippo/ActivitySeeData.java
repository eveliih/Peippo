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

/**
 * Luokka hakee käyttäjän syöttämät tiedot SingletonPeippoVariablesList-luokasta
 * ja tuottaa niistä yhdistelmädiagrammin.
 * @author Hanne
 */

public class ActivitySeeData extends AppCompatActivity {
    private CombinedChart peippoChart;
    private ArrayList<Entry> lineOne = new ArrayList<>();
    private ArrayList<Entry> lineTwo = new ArrayList<>();
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private String [] labels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_data);
        getSavedData();
        initCombinedChart();
        showCombinedChart();
    }

    /* Metodi hakee käyttäjän tallentamat tiedot Singletonista
    * ja lisää ne diagrammin viivojen ja pylvään omiin ArrayListeihin */
    private void getSavedData() {
        ArrayList<PeippoVariables> peippoList = SingletonPeippoVariablesList.getInstance().getList();
        int labelsSize = peippoList.size() + 1;
        labels = new String[labelsSize];
        labels[0] = " ";
        for (int i = 0; i < peippoList.size(); i++) {
            lineOne.add(new Entry(i + 1, peippoList.get(i).getMood()));
            lineTwo.add(new Entry(i + 1, peippoList.get(i).getTiredness()));
            entries.add(new BarEntry(i + 1, peippoList.get(i).getSleptHours()));
            String date = peippoList.get(i).getDate();
            int a = i + 1;
            labels[a] = date;
        }
        }


        /* Metodi asettaa viiva- ja pylväsdatan yhdistelmädiagrammiin
        * sekä avaa diagrammin  */
        private void showCombinedChart() {
            CombinedData data = new CombinedData();

            data.setData(generateLineData());
            data.setData(generateBarData());

            XAxis xAxis = peippoChart.getXAxis();
            xAxis.setAxisMaximum(data.getXMax() + 0.40f);
            peippoChart.setData(data);
            peippoChart.invalidate();
            peippoChart.setVisibleXRangeMaximum(11);
        }

        /* Metodi asettaa yhdistelmädiagrammin ulkoasun */
        private void initCombinedChart() {
            peippoChart = findViewById(R.id.combinedChart);
            peippoChart.setBackgroundColor(Color.WHITE);
            peippoChart.setDrawGridBackground(true);
            peippoChart.setDrawBarShadow(true);
            peippoChart.getDescription().setText(" ");

            /* Laittaa viivat näkymään pylväiden päällä */
            peippoChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                    CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
            });

            /* Asettelee pylväiden ja viivojen selitysmerkit */
            Legend legend = peippoChart.getLegend();
            legend.setWordWrapEnabled(true);
            legend.setTextSize(12f);
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

            /* Asettaa Y ja X-akselien merkinnät */
            YAxis rightAxis = peippoChart.getAxisRight();
            rightAxis.setDrawGridLines(false);
            rightAxis.setAxisMinimum(0f);
            rightAxis.setLabelCount(16);
            rightAxis.setAxisMaximum(24);

            YAxis leftAxis = peippoChart.getAxisLeft();
            leftAxis.setDrawGridLines(false);
            leftAxis.setAxisMinimum(0f);
            leftAxis.setLabelCount(16);
            leftAxis.setAxisMaximum(24);
            peippoChart.setVisibleYRangeMaximum(16, YAxis.AxisDependency.LEFT);

            XAxis xAxis = peippoChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setAxisMinimum(0f);
            xAxis.setGranularity(1f);
            xAxis.setLabelCount(11);
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        }


    /* Metodi tuottaa viivadiagrammit ja asettaa viivojen ulkoasun */
    private LineData generateLineData() {
        LineDataSet set1 = new LineDataSet(lineOne, "Mieliala (1-5)");
        LineDataSet set2 = new LineDataSet(lineTwo, "Virkeys (1-5)");

        set1.setColor(Color.rgb(120, 220, 100));
        set1.setLineWidth(2f);
        set1.setCircleColor(Color.rgb(120, 220, 100));
        set1.setCircleRadius(3f);
        set1.setFillColor(Color.rgb(120, 220, 100));
        set1.setMode(LineDataSet.Mode.LINEAR);
        set1.setDrawValues(false);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.BLACK);

        set2.setColor(Color.rgb(80, 120, 220));
        set2.setLineWidth(2f);
        set2.setCircleColor(Color.rgb(80, 120, 220));
        set2.setCircleRadius(3f);
        set2.setFillColor(Color.rgb(80, 120, 220));
        set2.setMode(LineDataSet.Mode.LINEAR);
        set2.setDrawValues(false);
        set2.setValueTextSize(10f);
        set2.setValueTextColor(Color.BLACK);

        set1.setHighlightEnabled(false);
        set2.setHighlightEnabled(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);

        return new LineData(dataSets);
    }


    /* Metodi tuottaa datan pylväsdiagrammiin */
    private BarData generateBarData() {
        BarDataSet set = new BarDataSet(entries, "Uni (tuntia)");
        set.setDrawValues(false);

        set.setColor(Color.rgb(184, 89, 77));
        set.setValueTextColor(Color.BLACK);
        set.setValueTextSize(10f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        float barWidth = 0.45f;
        BarData bardata = new BarData(set);
        bardata.setBarWidth(barWidth);
        return bardata;

    }

}