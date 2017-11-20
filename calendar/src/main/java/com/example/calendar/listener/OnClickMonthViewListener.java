package com.example.calendar.listener;

import org.joda.time.DateTime;


public interface OnClickMonthViewListener {

    void onClickCurrentMonth(DateTime dateTime);

    void onClickLastMonth(DateTime dateTime);

    void onClickNextMonth(DateTime dateTime);

}
