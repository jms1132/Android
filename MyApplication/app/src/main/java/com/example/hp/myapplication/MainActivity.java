package com.example.hp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPrevious, btnNext;
    private GridView gvCalendar;
    private TextView tvMonthCalendar;
    private MonthAdapter monthViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvCalendar = findViewById(R.id.gvCalendar);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        tvMonthCalendar = findViewById(R.id.tvMonthCalendar);

        //1. 어댑터를 만든다.
        monthViewAdapter = new MonthAdapter(this);
        gvCalendar.setAdapter(monthViewAdapter);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        setYearMonth();

        gvCalendar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonthItemData currentItem = monthViewAdapter.items[position];
                int day = currentItem.getDayValue();
                String message = monthViewAdapter.currentYear + "년 " + monthViewAdapter.currentMonth + "월 "+ day+"일"+" 고생고생:(";
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrevious:
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();
                setYearMonth();
                break;

            case R.id.btnNext:
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();
                setYearMonth();
                break;
        }
    }

    private void setYearMonth() {
        String yearMonth = monthViewAdapter.currentYear + "년 " + (monthViewAdapter.currentMonth+1) + "월";
        tvMonthCalendar.setText(yearMonth);
    }

}
