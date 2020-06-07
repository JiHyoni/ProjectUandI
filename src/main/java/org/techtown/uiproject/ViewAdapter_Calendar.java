package org.techtown.uiproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewAdapter_Calendar extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> list = new ArrayList<String>();
    public ViewAdapter_Calendar(FragmentManager fm) {
        super(fm);
        items= new ArrayList<Fragment>();
        items.add(new Calendar());
        items.add(new CalendarList());

        list.add("캘린더");
        list.add("일정보기");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
    public CharSequence getPageTitle(int position){
        return list.get(position);
    }
}
