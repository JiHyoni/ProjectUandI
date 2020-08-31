package org.techtown.uiproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class event3Activity extends AppCompatActivity {

    TextView t2, t3, t6, t7, t8;
    ImageView i1;
    ImageView ib1, ib2;
    event_list list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        i1 = (ImageView) findViewById(R.id.i1);
        ib1 = (ImageView) findViewById(R.id.ib1);
        ib2 = (ImageView) findViewById(R.id.ib2);

        Intent intent = getIntent();
        list = intent.getParcelableExtra("act3");
        t2.setText(list.name);
        t3.setText(list.menu[0]);
        t6.setText(list.call);
        t7.setText(list.adress);
        t8.setText(list.when);
        image(list.category);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.b4) {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        } else {
            if (v.getId() == R.id.ib1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + list.call));
                startActivity(intent);
            } else if (v.getId() == R.id.ib2) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + list.adress));
                startActivity(intent);
            }
        }
    }


    public void image(String a) {
        if (a == "VOLUNTEER") {
            i1.setImageResource(R.drawable.volunteer);
        } else if (a == "SING") {
            i1.setImageResource(R.drawable.sing);
        } else if (a == "EDU") {
            i1.setImageResource(R.drawable.edu);
        }
    }

}
