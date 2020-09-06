package org.techtown.uiproject.caringlist;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.techtown.uiproject.caringlist.SearchFragment;
import org.techtown.uiproject.caringlist.addFragment;

import java.util.ArrayList;
public class ViewAdapter extends FragmentPagerAdapter {  //탭 부분화면을 손으로 밀때 슬라이딩
    private ArrayList <Fragment> items;
    private ArrayList <String> list = new ArrayList<String>();

    public ViewAdapter(FragmentManager fm){
        super(fm);
        items= new ArrayList<Fragment>(); //Fragment 를 ArrayList로 만들어줌
        items.add(new addFragment()); // ArrayList 에 addFragment 메뉴탭에 들어갈 객체 생성해주기
        items.add(new SearchFragment()); //ArrayList 에 searchFragment 메뉴탭에 들어갈 객체 생성해주기

        list.add("추가하기");
        list.add("조회하기");
    }
    public CharSequence getPageTitle(int position){
        return list.get(position);
    }

    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
