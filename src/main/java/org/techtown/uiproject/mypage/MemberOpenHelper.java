package org.techtown.uiproject.mypage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MemberOpenHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="DB";
    public static final String TABLE_NAME="UserTable";
    public static final String Table_Column_ID="id";
    public static final String Table_Column_1_Name="name";
    public static final String Table_Column_2_Email="email";
    public static final String Table_Column_3_Password="password";
    public static final String Table_Column_4_Mobile= "mobile";
    public MemberOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "
                +TABLE_NAME+ " (" + Table_Column_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , "
                +Table_Column_1_Name + " VARCHAR, "
                +Table_Column_2_Email + " VARCHAR, "
                +Table_Column_3_Password + " VARCHAR, "
                +Table_Column_4_Mobile+ " VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}

