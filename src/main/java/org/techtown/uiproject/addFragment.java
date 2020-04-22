package org.techtown.uiproject;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addFragment extends Fragment { //추가하기 탭의 부분화면
    EditText editText, editText1, editText2, editText3;
    DBHelper dbHelper;
    String name, number, address, bisang;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        //inflate 로 부분화면을 추가해준다.
        dbHelper = new DBHelper(getContext());

        editText = view.findViewById(R.id.editName);
        editText1 = view.findViewById(R.id.editNum);
        editText2 = view.findViewById(R.id.editAdress);
        editText3 = view.findViewById(R.id.editHelpnum);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //추가하기 버튼을 클릭하는 순간 db에 저장해주는 코드 추가하기
                name = editText.getText().toString();
                number =editText1.getText().toString();
                address = editText2.getText().toString();
                bisang = editText3.getText().toString();

                dbHelper.insert(name, number, address, bisang); //db 저장
                Toast.makeText(getContext(),"추가완료 ",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
