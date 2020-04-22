package org.techtown.uiproject;
import androidx.appcompat.widget.Toolbar;
import android.graphics.Color;
import android.os.Build;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    ImageButton button2; //돌봄리스트 = 케어링 리스트
    ImageButton button5; //영상통화
    ImageButton button4; //행사안내
    ImageButton button3; //캘린더
    ImageButton button1; //마이페이지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //R 은 리소스 아래 layout 에 activitymain 이 있다
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //상태바를 하얀색으로 설정해주는 코드
        if(Build.VERSION.SDK_INT >= 21){
            getWindow().setStatusBarColor(Color.rgb(0,0,0));
        }

        // 툴바의 마이페이지
        button1 = findViewById(R.id.imageButton1); //마이페이지 버튼
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mypageActivity.class );
                startActivity(intent);
            }
        });


        // 4개의 버튼 생성후 다음의 페이지로 넘어가는 코드들 아래
        button2 = findViewById(R.id.imageButton2); //케어링 리스트 버튼

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,caringlistActivity.class );
                startActivity(intent);
            }
        });

        button5 = findViewById(R.id.imageButton5); //영상통화 버튼

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,videocallActivity.class );
                startActivity(intent);
            }

        });

        button4 = findViewById(R.id.imageButton4); //행사안내 버튼
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,eventActivity.class );
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.imageButton3); //캘린더 버튼

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,calenderActivity.class );
                startActivity(intent);
            }
        });
    }
    }