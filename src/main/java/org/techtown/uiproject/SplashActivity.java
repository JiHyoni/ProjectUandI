package org.techtown.uiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
            Thread.sleep(2000);
            Intent mainIntent= new Intent(this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
