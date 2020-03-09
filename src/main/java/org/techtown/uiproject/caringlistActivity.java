package org.techtown.uiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class caringlistActivity extends AppCompatActivity { //케어링리스트 클릭시 실행되는 main

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caringlist);

        ViewPager vp = findViewById(R.id.viewpager);
        ViewAdapter adapter = new ViewAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        //viewpager 와 adapter 생성후 연결

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
        //tab을 viewpager 와 연결

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.add);
        images.add(R.drawable.list);
        for(int i = 0; i < 2; i++) tab.getTabAt(i).setIcon(images.get(i));
        //탭에 이미지 붙여주기
    }
    public  void onClick(View v){
        finish();
    }
}
