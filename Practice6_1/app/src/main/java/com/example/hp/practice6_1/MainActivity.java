package com.example.hp.practice6_1;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    LinearLayout chronometerEnd;
    RadioButton rdoCal, rdoTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay, selectHour, selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer = findViewById(R.id.chronometer);
        chronometerEnd = findViewById(R.id.chronometerEnd);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        //1. 크로노미터 클릭하면 라디오버튼 보이게 한다.
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);

            }
        });

        //2. 라디오버튼 CalenderView, TimePicker 선택가능하다.
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        selectYear = datePicker.getYear();
        selectMonth = datePicker.getMonth() + 1;
        selectDay = datePicker.getDayOfMonth();

//        //3. 날짜와 시간을 선택했을 때 설정값을 저장한다.
//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                selectYear = year;
//                selectMonth = monthOfYear + 1;
//                selectDay = dayOfMonth;
//            }
//        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectHour = hourOfDay;
                selectMinute = minute;
            }
        });

        //4. 아래쪽 크로노미터를 누르면 예약된 날짜와 시간을 가져온다.
        chronometerEnd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(selectHour));
                tvMinute.setText(Integer.toString(selectMinute));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);

                return false;
            }
        });

    }
}
