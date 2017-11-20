package com.example.calendar.listener;

import org.joda.time.DateTime;


public interface OnCalendarChangedListener {
    void onCalendarChanged(DateTime dateTime);
}
