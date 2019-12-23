package com.example.hp.mycalendarproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnPrevious, btnNext;
    private GridView gvCalendar;
    private TextView tvMonthCalendar;
    private MonthAdapter monthAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        gvCalendar = findViewById(R.id.gvCalendar);
        tvMonthCalendar = findViewById(R.id.tvMonthCalendar);

        monthAdapter = new MonthAdapter(this);
        gvCalendar.setAdapter(monthAdapter);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        setYearMonth();

        gvCalendar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                MonthItemData currentItem = monthAdapter.items[position];
                int day = currentItem.getDayValue();
                String Date = monthAdapter.currentYear + "년 " + (monthAdapter.currentMonth + 1) + "월 " + day + "일";
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_register, null);
                final EditText editEvent = view.findViewById(R.id.editEvent);
                TextView tvShowToday = view.findViewById(R.id.tvShowToday);
                tvShowToday.setText(Date);

                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("이벤트 추가");
                dialog.setView(view);
                dialog.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    monthAdapter.items[position].setEventThing(editEvent.getText().toString());
                    monthAdapter.items[position].setEventExist(true);
                    monthAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("취소", null);
                android.util.Log.i("MusicService", "stopService()");

                dialog.show();

            }
        });
    }

    private void setYearMonth() {
        String yearMonth = monthAdapter.currentYear + "년 " + (monthAdapter.currentMonth + 1) + "월";
        tvMonthCalendar.setText(yearMonth);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrevious:
                gvCalendar.removeAllViewsInLayout();
                monthAdapter.setPreviousMonth();
                monthAdapter.notifyDataSetChanged();
                setYearMonth();
                break;

            case R.id.btnNext:
                gvCalendar.removeAllViewsInLayout();
                monthAdapter.setNextMonth();
                monthAdapter.notifyDataSetChanged();
                setYearMonth();
                break;
        }
    }
}
