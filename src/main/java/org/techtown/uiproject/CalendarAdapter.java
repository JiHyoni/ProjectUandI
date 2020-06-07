package org.techtown.uiproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CalendarAdapter extends FragmentPagerAdapter {
    int tabnumber;
    public CalendarAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabnumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Calendar tab1 = new Calendar();
                return tab1;
            case 1:
                CalendarList tab2 = new CalendarList();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
