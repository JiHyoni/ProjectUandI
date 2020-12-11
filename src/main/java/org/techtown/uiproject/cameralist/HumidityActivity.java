package org.techtown.uiproject.cameralist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
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
        set1 = new LineDataSet(values, "습도 (%)");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets
        // create a data object with the data sets
        LineData data = new LineData(dataSets);

        // black lines and points
        set1.setColor(Color.BLUE);
        set1.setCircleColor(Color.BLACK);

        // set data
        chart.setData(data);
    }
}