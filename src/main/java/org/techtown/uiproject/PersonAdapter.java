package org.techtown.uiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    //리싸이클러뷰에 필요함! fragment_search 를 뷰홀더에 담는 작업
    ArrayList<Person> items =new ArrayList<Person>();

    //3개의 메소드 오버라이딩 해주기
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 뷰홀더 create 는 inflation 이 필요함
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.fragment_search,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size(); // 생성되는 카드뷰 갯수
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        //fragment_search.xml 에 들어있는 레이아웃을 뷰홀더에 넣기 위한 작업
        //각각의 아이템에 들어갈 내용을 설정해줌
        TextView textView;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);

        }

        public void setItem (Person person){
            textView.setText("성함: "+person.getName());
            textView1.setText("연락처: "+person.getNumber());
            textView2.setText("주소: "+person.getAddress());
            textView3.setText("비상연락처: "+person.getBisang());
        }
    }
    public void addItem ( Person person){
        items.add(person);
    }
}
