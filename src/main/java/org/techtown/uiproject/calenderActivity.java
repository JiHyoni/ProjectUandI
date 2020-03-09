package org.techtown.uiproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class calenderActivity extends AppCompatActivity {
    private LinearLayout header1;
    private TextView monthText;
    private GridView monthView;
    private Calendar calendar;
    private CalendarAdapter monthViewAdapter;
    int curYear;
    int curMonth;
    int curDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        monthView = (GridView) findViewById(R.id.monthView);
        monthViewAdapter = new CalendarAdapter(this);
        monthView.setAdapter(monthViewAdapter);

        // 리스너 설정
        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 현재 선택한 일자 정보 표시
                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position);
                int day = curItem.getDay();
                Log.d("CalendarActivity", "Selected : " + day);
                AlertDialog.Builder dlg = new AlertDialog.Builder(calenderActivity.this);
                dlg.setMessage("디비에서 추가된 일정").setCancelable(false)
                        .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert = dlg.create();
                alert.setTitle(curYear + "년 " + (curMonth + 1) + "월 "+curItem.getDay()+"일");
                alert.setIcon(R.drawable.mcv_action_next);
                alert.show();
            }
        });
        monthText = (TextView) findViewById(R.id.monthText);
        setMonthText();
        // 이전 월로 넘어가는 이벤트 처리
        Button monthPrevious = (Button) findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();
                setMonthText();
            }
        });
        // 다음 월로 넘어가는 이벤트 처리
        Button monthNext = (Button) findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();
                setMonthText();
            }
        });
    }
    /**

     * 월 표시 텍스트 설정

     */
    private void setMonthText() {
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();
        curDay = monthViewAdapter.getCurDay();
        monthText.setText(curYear + "년 " + (curMonth + 1) + "월"+curDay+"일");
    }
}