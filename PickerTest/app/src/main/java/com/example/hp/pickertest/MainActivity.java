package com.example.hp.pickertest;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calendarView;
    TimePicker timePicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay, selectHour, selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        timePicker.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);

        //1. 라디오버튼 CalenderView, TimePicker 선택가능하다.
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        //2. 예약 시작을 누르면 타이머가 작동한다.(크로노미터)
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        //3. 날짜와 시간을 선택했을 때 설정값을 저장한다.
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;

            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectHour = hourOfDay;
                selectMinute = minute;
            }
        });

        //4. 예약 완료를 누르면 예약된 날짜와 시간을 가져온다.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(selectHour));
                tvMinute.setText(Integer.toString(selectMinute));
            }
        });

    }
}
