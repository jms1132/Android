package com.example.hp.myapplication;

// view에 들어갈 데이터값
public class MonthItemData {

    private int dayValue;

    public MonthItemData() {
    }

    public MonthItemData(int dayValue) {
        this.dayValue = dayValue;
    }

    public int getDayValue() {
        return dayValue;
    }

    public void setDayValue(int dayValue) {
        this.dayValue = dayValue;
    }
}
