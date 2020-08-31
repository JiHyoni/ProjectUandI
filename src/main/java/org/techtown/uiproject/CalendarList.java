package org.techtown.uiproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;;
import java.util.ArrayList;
import androidx.recyclerview.widget.ItemTouchHelper;

public class CalendarList extends Fragment{
    RecyclerView recyclerView;
    InfoAdapter adapter;
    MemoDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calendar_list, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        dbHelper = new MemoDBHelper(getContext());
        adapter = new InfoAdapter();
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                ArrayList<Info> result = dbHelper.selectAll();
                result.remove(viewHolder.getLayoutPosition());
               // db.delete("MEMO.db","_id",null);
               // adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        Button button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //버튼클릭하면 추가한 정보들이 나타남 update 정보 포함해주기 (db에서 가져오기)
                ArrayList<Info> result = dbHelper.selectAll();
                adapter.setItems(result);
                adapter.notifyDataSetChanged();
            }
        });
        return rootView;
    }
}
