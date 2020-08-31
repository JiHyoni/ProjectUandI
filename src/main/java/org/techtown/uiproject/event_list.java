package org.techtown.uiproject;

import android.os.Parcel;
import android.os.Parcelable;

public class event_list implements Parcelable {
    String name = "";
    String call = "";
    String menu[] = new String[3];
    String adress = "";
    String when = "";
    String category = "";

    public event_list(String name, String call, String[] menu, String adress, String when, String category) {
        this.name = name;
        this.call = call;
        this.menu = menu;
        this.adress = adress;
        this.when = when;
        this.category = category;
    }

    protected event_list(Parcel in) {
        name = in.readString();
        call = in.readString();
        menu = in.createStringArray();
        adress = in.readString();
        when = in.readString();
        category = in.readString();
    }

    public static final Creator<event_list> CREATOR = new Creator<event_list>() {
        @Override
        public event_list createFromParcel(Parcel in) {
            return new event_list(in);
        }

        @Override
        public event_list[] newArray(int size) {
            return new event_list[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(call);
        dest.writeStringArray(menu);
        dest.writeString(adress);
        dest.writeString(when);
        dest.writeString(category);
    }
}