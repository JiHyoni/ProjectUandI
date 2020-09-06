package org.techtown.uiproject.mypage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.uiproject.R;

public class Register extends AppCompatActivity {
    EditText Email, Password, Name, Mobile;
    Button Register;
    String NameHolder, EmailHolder, PasswordHolder, MobileHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    MemberOpenHelper memberOpenHelper;
    Cursor cursor;
    String F_Result = "Not Found";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);
        Name = (EditText)findViewById(R.id.editName);
        Mobile = (EditText)findViewById(R.id.editMobile);

        memberOpenHelper = new MemberOpenHelper(this);

        //회원가입 버튼에 클릭 이벤트 추가하기
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();


            }
        });

    }
    //데이터베이스 생성하는 메소드
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(MemberOpenHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    //테이블 생성 메소드
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + MemberOpenHelper.TABLE_NAME + "("
                + MemberOpenHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + MemberOpenHelper.Table_Column_1_Name + " VARCHAR, "
                + MemberOpenHelper.Table_Column_2_Email + " VARCHAR, "
                + MemberOpenHelper.Table_Column_3_Password + " VARCHAR, "
                + MemberOpenHelper.Table_Column_4_Mobile + "VARCHAR);");

    }

    // 데이터베이스 메소드 안에 데이터 삽입하기
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+MemberOpenHelper.TABLE_NAME+" (name,email,password,mobile) VALUES('"+NameHolder+"', '"+EmailHolder+"', '"+PasswordHolder+"', '"+MobileHolder+"');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(Register.this,"회원가입을 성공했습니다!", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(Register.this,"모든 영역을 채워주세요.", Toast.LENGTH_LONG).show();

        }

    }
    //데이터 삽입을 수행한 후에 editText 부분을 Empty로 변경하기
    public void EmptyEditTextAfterDataInsert(){

        Name.getText().clear();

        Email.getText().clear();

        Password.getText().clear();

        Mobile.getText().clear();

    }

    //EditText 부분이 비었는지 아닌지 확인하는 메소드
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        NameHolder = Name.getText().toString() ;
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();
        MobileHolder = Mobile.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(MobileHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // 있는 이메일인지 아닌지 체크하기
    public void CheckingEmailAlreadyExistsOrNot(){

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = memberOpenHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(MemberOpenHelper.TABLE_NAME, null, " " + MemberOpenHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }
    // Checking result
    public void CheckFinalResult(){

        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {

            // If email is exists then toast msg will display.
            Toast.makeText(Register.this,"이미 존재하는 이메일입니다.", Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }


}
