package org.techtown.uiproject;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SearchFragment extends Fragment { //조회하기 탭의 부분화면
    RecyclerView recyclerView;
    PersonAdapter adapter;
    TextView textView;
    public SearchFragment() {// Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_recyclerview,container,false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        textView= rootView.findViewById(R.id.textView4); // 총 몇명인지 count

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);

        Button button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //버튼클릭하면 추가한 정보들이 나타남 update 정보 포함해주기 (db에서 가져오기)
                adapter.addItem(new Person("지톨","010-1111-1111","한국","112"));
                textView.setText("total : "+adapter.getItemCount()+" 명");
                adapter.notifyDataSetChanged();
            }
        });
        return rootView;

    }

}
