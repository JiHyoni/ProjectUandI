package org.techtown.uiproject.calendar;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.techtown.uiproject.R;

public class Calendar extends Fragment {
    TextView textView;
    ContentValues contentValues = new ContentValues();
    MemoDBHelper db;
    AlertDialog.Builder ad ;
    String contents;
    String date;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar,container,false);
        CalendarView calendar = (CalendarView)view.findViewById(R.id.calendarView);
        textView = view.findViewById(R.id.textView2);
        ad = new AlertDialog.Builder(getContext());

        db = new MemoDBHelper(getContext());
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                final EditText edittext = new EditText(getContext());
                ad.setTitle(year+"년 "+(month+1)+"월 "+dayOfMonth+"일 " );
                ad.setMessage("일정을 추가해주세요! ");
                ad.setView(edittext);
                date = year + "년 " + (month + 1) + "월 " + dayOfMonth +"일";
                ad.setPositiveButton("입력",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(),"일정이 추가되었습니다.", Toast.LENGTH_LONG).show();
                                contents = edittext.getText().toString();
                                db.insert(date,contents);
                            }
                        });
                ad.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(),"취소를 선택했습니다.", Toast.LENGTH_LONG).show();
                            }
                        });
                ad.show();
            }
        });
        return view;
    }
}
