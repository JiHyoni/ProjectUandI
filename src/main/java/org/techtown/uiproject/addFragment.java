package org.techtown.uiproject;
import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class addFragment extends Fragment { //추가하기 탭의 부분화면
    EditText editText, editText1, editText2, editText3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        //inflate 로 부분화면을 추가해준다.

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //추가하기 버튼을 클릭하는 순간 db에 저장해주는 코드 추가하기
                editText = view.findViewById(R.id.editName);
                editText1 = view.findViewById(R.id.editNum);
                editText2 = view.findViewById(R.id.editAdress);
                editText3 = view.findViewById(R.id.editHelpnum);

            }
        });
        return view;
    }

}
