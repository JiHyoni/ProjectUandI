package org.techtown.uiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class videocallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videocall);
    }
    //버튼 클릭시 보여지는 화면에 관련된 코드
    public  void onClick(View v){
        finish();
    }

}
