package org.techtown.uiproject.soslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.techtown.uiproject.R;

import java.io.IOException;

public class SosListActivity extends AppCompatActivity {
    TextView tv_sos;
    Button btn_sos;
    String url = "0/jspbook/jspbook/sos/main.jsp"; // ip주소 실행환경에계속 변경해줘야됨
    String msg ;
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_list);

        tv_sos = findViewById(R.id.tv_sos);
        btn_sos = findViewById(R.id.btn_sos);

        btn_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        Document doc = null;
                        try {
                            doc = Jsoup.connect(url).get();
                            Elements elements = doc.select("li"); // 시간, 원하는 부분 태그로 가져오기 !

                            msg = elements.text();
                            bundle.putString("message", msg);  //핸들러를 이용해서 Thread()에서 가져온 데이터를 메인스레드에게 보내주기

                            Message msg = handler.obtainMessage();
                            msg.setData(bundle);
                            handler.sendMessage(msg);
                            bundle.getBundle("message");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
            }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            tv_sos.setText(bundle.getString("message"));
        }
    };
    }


