package org.techtown.uiproject;

/**

 * 일자 정보를 담기 위한 클래스 정의

 */
class MonthItem {
    private int dayValue;
    private Object view;
    public MonthItem() {
    }
    public MonthItem(int day) {
        dayValue = day;
    }
    public int getDay() {
        return dayValue;
    }
    public void setDay(int day) {
        this.dayValue = day;
    }
}