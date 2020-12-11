package org.techtown.uiproject.cameralist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.uiproject.R;

public class CameraListActivity extends AppCompatActivity {
    Button cameraBtn, humBtn, tempBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_list);

        cameraBtn = findViewById(R.id.cameraBtn);
        humBtn = findViewById(R.id.humBtn);
        tempBtn = findViewById(R.id.tempBtn);

        humBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraListActivity.this, HumidityActivity.class));
            }
        });

        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraListActivity.this, TemperatureActivity.class));

            }
        });
    }





}