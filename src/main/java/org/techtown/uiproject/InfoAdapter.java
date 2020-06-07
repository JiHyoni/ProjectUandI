package org.techtown.uiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter  extends RecyclerView.Adapter<InfoAdapter.ViewHolder>{
    ArrayList<Info> items =new ArrayList<Info>();

    //3개의 메소드 오버라이딩 해주기
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 뷰홀더 create 는 inflation 이 필요함
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.fragment_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Info item = items.get(position);
        holder.setItem(item);
    }
    public void setItems(ArrayList<Info> items) {
        this.items = items;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView1);

        }

        public void setItem (Info info){
            textView.setText(info.getDate());
            textView1.setText(info.getContents());
        }
    }
    public void addItem ( Info info){
        items.add(info);
    }
}
