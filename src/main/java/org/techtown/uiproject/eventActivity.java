package org.techtown.uiproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class eventActivity extends AppCompatActivity {

    TextView t1;
    ListView l1;
    final int request_code_1 = 1;
    final int request_code_2 = 2;
    ArrayList<event_list> information = new ArrayList<event_list>();
    ArrayAdapter<String> list;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        t1 = (TextView)findViewById(R.id.t1);
        l1 = (ListView)findViewById(R.id.listview);
        list = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        l1.setAdapter(list);
        list_longorder();
        list_order();
    }



    void list_longorder() {
        l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(eventActivity.this);
                dlg.setTitle("삭제확인").setNegativeButton("취소", null).setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        count--;
                        t1.setText("행사 리스트" + count + "개");
                        list.remove(information.get(position).name);
                        list.notifyDataSetChanged();

                    }
                }).show();

                return true;
            }
        });
    }

    void list_order() {
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent3 = new Intent(eventActivity.this,event3Activity.class);
                intent3.putExtra("act3", (Parcelable) information.get(position));
                startActivityForResult(intent3,request_code_2);
            }
        });
    }

    public void onclick(View v){
        if(v.getId() == R.id.b1){
            Intent intent2 = new Intent(eventActivity.this, event2Activity.class);
            startActivityForResult(intent2,request_code_1);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == request_code_1 && resultCode == RESULT_OK) {
            count++;
            t1.setText("행사 리스트" + count + "개");
            event_list i1 = data.getParcelableExtra("name");
            information.add(i1);
            list.add(i1.name);
            list.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}