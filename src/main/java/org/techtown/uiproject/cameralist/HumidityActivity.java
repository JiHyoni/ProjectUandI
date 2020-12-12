package org.techtown.uiproject.cameralist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.techtown.uiproject.R;

import java.util.ArrayList;

public class HumidityActivity extends AppCompatActivity {
    private LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);

        chart = findViewById(R.id.linechart2);
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            float val = (float) ((Math.random() * 20) + 40);
            values.add(new Entry(i, val));
        }

        LineDataSet set1;
        set1 = new LineDataSet(values, "습도 (%) (*적정습도: 40-60%) ");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets
        // create a data object with the data sets
        LineData data = new LineData(dataSets);

        // black lines and points
        set1.setColor(Color.BLUE);
        set1.setCircleColor(Color.parseColor("#FFA1B4DC"));
        set1.setLineWidth(1);
        set1.setDrawCircleHole(true);
        set1.setDrawCircles(true);
        set1.setCircleRadius(5);
        set1.setCircleHoleColor(Color.BLUE);
        set1.setValueTextSize(12f);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxis = chart.getAxisRight();
        yAxis.setDrawLabels(false);
        yAxis.setDrawAxisLine(false);
        yAxis.setDrawGridLines(false);
        // set data
        chart.setData(data);
    }
}
