package com.example.calenderselect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calendar.calendar.MonthCalendar;
import com.example.calendar.listener.OnMonthCalendarChangedListener;
import com.example.wheelview.TimePickerLayout;
import com.gyf.barlibrary.ImmersionBar;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{

    private ImmersionBar mImmersionBar;
    private TimePickerLayout mTimePickerLayout;
    private TextView mTvTitleTime;
    private LinearLayout mLlTimePickLayout;
    private MonthCalendar mMonthCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setTitleImmersion();
        initView();
        initData();
    }

    private void setTitleImmersion() {
        mImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.title_bg_color)
                .init();
    }

    private void initView() {
        findViewById(R.id.ivBack).setOnClickListener(this);
        mTvTitleTime = (TextView) findViewById(R.id.tvTitleTime);
        mTvTitleTime.setOnClickListener(this);
        mLlTimePickLayout = (LinearLayout) findViewById(R.id.llTimePickLayout);
        mTimePickerLayout = (TimePickerLayout) findViewById(R.id.timePicker);
        findViewById(R.id.tvCancel).setOnClickListener(this);
        findViewById(R.id.tvSure).setOnClickListener(this);
        findViewById(R.id.rlTimePickBg).setOnClickListener(this);
        mMonthCalendar = (MonthCalendar) findViewById(R.id.monthCalendar);
        mMonthCalendar.setDateInterval("2016-01-01","2019-12-31");
        mMonthCalendar.setOnMonthCalendarChangedListener(new OnMonthCalendarChangedListener() {
            @Override
            public void onMonthCalendarChanged(DateTime dateTime) {
                int year = mMonthCalendar.getYear();
                int month = mMonthCalendar.getMonth();
                int day = mMonthCalendar.getDay();
                mTvTitleTime.setText(year+"年"+month+"月");
                mTimePickerLayout.setData(year,month);
                Toast.makeText(CalendarActivity.this,year+"年"+ month+"月"+day+"日",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initData() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        mTvTitleTime.setText(year+"年"+month+"月");
        mTimePickerLayout.setData(year,month);
        setSelectDate();
    }

    public void setSelectDate() {
        List<String> list = new ArrayList<>();
        list.add("2017-09-21");
        list.add("2017-10-21");
        list.add("2017-10-1");
        list.add("2017-10-15");
        list.add("2017-10-18");
        list.add("2017-10-26");
        list.add("2017-11-20");
        list.add("2017-11-21");
        mMonthCalendar.setPointList(list);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlTimePickBg:
                break;
            case R.id.tvTitleTime:
                mLlTimePickLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.tvSure:
                String year = mTimePickerLayout.getYear().substring(0,mTimePickerLayout.getYear().length()-1);
                String month = mTimePickerLayout.getMonth().substring(0,mTimePickerLayout.getMonth().length()-1);
                mTvTitleTime.setText(mTimePickerLayout.getYear()+mTimePickerLayout.getMonth());
                mLlTimePickLayout.setVisibility(View.GONE);
                mMonthCalendar.setDate(year,month);
                break;
            case R.id.tvCancel:
                mLlTimePickLayout.setVisibility(View.GONE);
                break;
        }
    }
}
