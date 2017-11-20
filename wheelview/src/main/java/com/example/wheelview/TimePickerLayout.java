package com.example.wheelview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;


import java.util.ArrayList;


public class TimePickerLayout extends LinearLayout {
    private WheelView mWheelYear;
    private WheelView mWheelMonth;

    private int starYear = 2016;
    private int endYear = 2019;

    public TimePickerLayout(Context context) {
        this(context, null);
    }

    public TimePickerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.layout_time_picker, this);
        mWheelYear = (WheelView) findViewById(R.id.wheelYear);
        mWheelMonth = (WheelView) findViewById(R.id.wheelMonth);

        mWheelYear.setData(getYearData());
        mWheelMonth.setData(getMonthData());
    }


    private ArrayList<String> getYearData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = starYear; i <=endYear; i++) {
            list.add(String.valueOf(i)+"年");
        }
        return list;
    }

    private ArrayList<String> getMonthData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(String.valueOf(i)+"月");
        }
        return list;
    }

    private ArrayList<String> getDayData() {
        //ignore condition
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    public String getYear() {
        if (mWheelYear == null) {
            return null;
        }
        return mWheelYear.getSelectedText();
    }

    public String getMonth() {
        if (mWheelMonth == null) {
            return null;
        }
        return mWheelMonth.getSelectedText();
    }

    public void setData(int year , int month){
        for (int i = starYear; i <=endYear; i++) {
            if (i == year){
                mWheelYear.setDefault(i - starYear);
            }
        }

        mWheelMonth.setDefault(month-1);
    }

}
