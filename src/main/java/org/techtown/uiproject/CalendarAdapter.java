package org.techtown.uiproject;
import android.content.Context;

import android.graphics.Color;

import android.text.format.Time;

import android.util.AttributeSet;

import android.util.Log;

import android.view.Gravity;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.GridView;



import java.util.Calendar;

import java.util.Date;
public class CalendarAdapter extends BaseAdapter {
    public static final String TAG = "CalendarAdapter";
    private MonthItem item;
    Context mContext;
    Context context;
    public static int oddColor = Color.rgb(225, 225, 225);
    public static int headColor = Color.rgb(12, 32, 158);
    private int selectedPosition = -1;
    private MonthItem[] items;
    private int countColumn = 7;
    int mStartDay;
    int startDay;
    int curYear;
    int curMonth;
    int curDay;
    int firstDay;
    int lastDay;
    int day;
    Calendar mCalendar;
    boolean recreateItems = false;
    private GridView monthView;
    public CalendarAdapter(Context context) {
        super();
        mContext = context;
        init();
    }
    public CalendarAdapter(Context context, AttributeSet attrs) {
        super();
        mContext = context;
        init();
    }
    private void init() {
        items = new MonthItem[7 * 6];
        mCalendar = Calendar.getInstance();
        recalculate();
        resetDayNumbers();
    }
    public void recalculate() {
        // set to the first day of the month
        mCalendar.set(Calendar.DAY_OF_MONTH, 1);
        // get week day
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        firstDay = getFirstDay(dayOfWeek);
        Log.d(TAG, "firstDay : " + firstDay);
        mStartDay = mCalendar.getFirstDayOfWeek();
        curYear = mCalendar.get(Calendar.YEAR);
        curMonth = mCalendar.get(Calendar.MONTH);
        curDay = mCalendar.get(Calendar.DATE);
        lastDay = getMonthLastDay(curYear, curMonth);
        Log.d(TAG, "curYear : " + curYear + ", curMonth : " + curMonth + ", lastDay : " + lastDay);
        int diff = mStartDay - Calendar.SUNDAY - 1;
        startDay = getFirstDayOfWeek();
        Log.d(TAG, "mStartDay : " + mStartDay + ", startDay : " + startDay);
    }
    public void setPreviousMonth() {
        mCalendar.add(Calendar.MONTH, -1);
        recalculate();
        resetDayNumbers();
        selectedPosition = -1;
    }

    public void setNextMonth() {
        mCalendar.add(Calendar.MONTH, 1);
        recalculate();
        resetDayNumbers();
        selectedPosition = -1;
    }

    public void resetDayNumbers() {
        for (int i = 0; i < 42; i++) {
            // calculate day number
            int dayNumber = (i + 1) - firstDay;
            if (dayNumber < 1 || dayNumber > lastDay) {
                dayNumber = 0;
            }
            // save as a data item
            items[i] = new MonthItem(dayNumber);
        }
    }
    private int getFirstDay(int dayOfWeek) {
        int result = 0;
        if (dayOfWeek == Calendar.SUNDAY) {
            result = 0;
        } else if (dayOfWeek == Calendar.MONDAY) {
            result = 1;
        } else if (dayOfWeek == Calendar.TUESDAY) {
            result = 2;
        } else if (dayOfWeek == Calendar.WEDNESDAY) {
            result = 3;
        } else if (dayOfWeek == Calendar.THURSDAY) {
            result = 4;
        } else if (dayOfWeek == Calendar.FRIDAY) {
            result = 5;
        } else if (dayOfWeek == Calendar.SATURDAY) {
            result = 6;
        }
        return result;
    }
    public int getCurYear() {
        return curYear;
    }

    public int getCurMonth() {
        return curMonth;
    }
    public int getCurDay() {
        return curDay;
    }
    public int getNumColumns() {
        return 7;
    }
    public int getCount() {
        return 7 * 6;
    }
    public Object getItem(int position) {
        return items[position];
    }



    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView(" + position + ") called.");
        Date today = new Date();
        MonthItemView itemView;
        //  int gridviewH = monthView.getHeight() / 7;

        if (convertView == null) {
            itemView = new MonthItemView(mContext);
        }
        else {
            itemView = (MonthItemView) convertView;
        }
        // create a params
        itemView.setLayoutParams(new GridView.LayoutParams(
                GridView.LayoutParams.MATCH_PARENT,
                120));
        // calculate row and column
        int rowIndex = position / countColumn;
        int columnIndex = position % countColumn;
        Log.d(TAG, "Index : " + rowIndex + ", " + columnIndex);
        // set item data and properties
        itemView.setItem(items[position]);
        itemView.setPadding(2, 2, 2, 2);
        // set properties
        itemView.setGravity(Gravity.CENTER);
/**            monthView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,120));

 monthView.setPadding(2,2,2,2);

 monthView.setOnClickListener(new View.OnClickListener() {

@Override

public void onClick(View view) {

View dialog = (View)View.inflate(CalendarAdapter.this,R.layout.dialog,null);

AlertDialog.Builder dlg = new AlertDialog.Builder(CalendarAdapter.this);



dlg.setTitle("Alert Dialog Title");

dlg.setMessage("Alert Dialog Content");

dlg.setView(dialog);

final Button confirm = (Button) dialog.findViewById(R.id.btnConfirm);

final EditText schedule = (EditText) dialog.findViewById(R.id.editSchedule);

dlg.setPositiveButton("입력",

new DialogInterface.OnClickListener() {

public void onClick(DialogInterface dialog, int which) {

Toast.makeText(context,schedule.getText().toString() , LENGTH_LONG).show();

}



});

dlg.setNegativeButton("취소",

new DialogInterface.OnClickListener() {

public void onClick(DialogInterface dialog, int which) {



}

});

dlg.show();

}

}); **/



        if (columnIndex == 0) {
            itemView.setTextColor(Color.RED);
        }
        else {
            itemView.setTextColor(Color.BLACK);
        }
        // set background color
        if (position == getSelectedPosition()) {
            itemView.setBackgroundColor(Color.YELLOW);
        } else {
            itemView.setBackgroundColor(Color.WHITE);
        }
        return itemView;
    }
    public static int getFirstDayOfWeek() {
        int startDay = Calendar.getInstance().getFirstDayOfWeek();
        if (startDay == Calendar.SATURDAY) {
            return Time.SATURDAY;
        } else if (startDay == Calendar.MONDAY) {
            return Time.MONDAY;
        } else {
            return Time.SUNDAY;
        }
    }
    private int getMonthLastDay(int year, int month){
        switch (month) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return (31);
            case 3:
            case 5:
            case 8:
            case 10:
                return (30);



            default:
                if(((year%4==0)&&(year%100!=0)) || (year%400==0) ) {

                    return (29);   // 2월 윤년계산

                } else {

                    return (28);

                }

        }

    }

    public void setSelectedPosition(int selectedPosition) {

        this.selectedPosition = selectedPosition;

    }
    /**

     * get selected row

     *

     * @return

     */
    public int getSelectedPosition() {
        return selectedPosition; }
}