package org.techtown.uiproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MemoDBHelper  extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="MEMO.db";
    public Context context;

    // 테이블을 생성하는 구문
    public MemoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context= context;
    }

    // DB를 새로 생성할 때 호출되는 함수
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        db.execSQL("CREATE TABLE MEMO (_id INTEGER PRIMARY KEY AUTOINCREMENT, Date TEXT, contents TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String Date, String contents) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = this.getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO MEMO VALUES(null, '" + Date + "', '" + contents + "');");
       // db.close();
    }
    public ArrayList<Info> selectAll() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Info> result_1 = new ArrayList<Info>();

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT date, contents FROM MEMO", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String date = cursor.getString(0);
            String contents = cursor.getString(1);
            Info info = new Info(date, contents);
            result_1.add(info);
        }

        return result_1;
    }

}
