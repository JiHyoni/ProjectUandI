package org.techtown.uiproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class event2Activity extends AppCompatActivity {
    EditText e1,e2,e3,e6;
    RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        e6 = (EditText)findViewById(R.id.e6);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
    }

    public void onClick(View v){

        if(v.getId() == R.id.b2){
            Intent intent1 = new Intent(this, eventActivity.class);
            setResult(RESULT_CANCELED,intent1);
            finish();
        }
        else if(v.getId() ==R.id.b3){
            String menu[] = new String[3];
            String name = e1.getText().toString();
            String call = e2.getText().toString();
            String category = "";
            menu[0] = e3.getText().toString();
            String adress = e6.getText().toString();
            String when = DateFormat.getDateInstance().format(new Date());
            if(r1.isChecked()) {
                category = "VOLUNTEER";
            }
            else if(r2.isChecked()){
                category = "SING";
            }
            else if(r3.isChecked()){
                category = "EDU";
            }
            event_list i= new event_list(name,call,menu,adress,when,category);
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.putExtra("name", (Parcelable) i);
            setResult(RESULT_OK,intent1);
            finish();

        }
    }
}