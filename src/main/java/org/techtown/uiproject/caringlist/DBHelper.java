package org.techtown.uiproject.caringlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "MYINFO.db";
    static final int DB_VERSION = 1;
    public Context context;

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context= context;
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        db.execSQL("CREATE TABLE MYINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, number TEXT, address TEXT,bisang TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, String number, String address, String bisang) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = this.getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO MYINFO VALUES(null, '" + name + "', '" + number + "', '" + address + "','" + bisang + "');");
        db.close();
    }

public ArrayList<Person> selectAll() {
    // 읽기가 가능하게 DB 열기
    SQLiteDatabase db = getReadableDatabase();
    ArrayList<Person> result_1 = new ArrayList<Person>();

    // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
    Cursor cursor = db.rawQuery("SELECT name, number, address, bisang FROM MYINFO", null);
    for (int i = 0; i < cursor.getCount(); i++) {
        cursor.moveToNext();
        String name = cursor.getString(0);
        String number = cursor.getString(1);
        String address = cursor.getString(2);
        String bisang = cursor.getString(3);
        Person info = new Person(name, number, address,bisang);
        result_1.add(info);
    }

    return result_1;
}


}