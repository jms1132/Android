package com.example.hp.navigationmenuttest;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    DrawerLayout mainDrawerLayout;
    LinearLayout drawMenu;
    Button btnOpen, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDrawerLayout = findViewById(R.id.mainDrawerLayout);
        drawMenu = findViewById(R.id.drawMenu);
        btnOpen = findViewById(R.id.btnOpen);
        btnClose = findViewById(R.id.btnClose);

        btnOpen.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        drawMenu.setOnTouchListener(this);

        mainDrawerLayout.setDrawerListener(listener);
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {

        @Override //슬라이딩을 시작했을 때 이벤트 발생
        public void onDrawerSlide(@NonNull View view, float v) {
            Toast.makeText(getApplicationContext(), "Open:)",Toast.LENGTH_SHORT).show();
        }

        @Override //메뉴를 열었을 때 이벤트 발생
        public void onDrawerOpened(@NonNull View view) {
            Toast.makeText(getApplicationContext(), "Open:)",Toast.LENGTH_SHORT).show();
        }

        @Override //메뉴를 닫았을 때 이벤트 발생
        public void onDrawerClosed(@NonNull View view) {
            Toast.makeText(getApplicationContext(), "Close:)",Toast.LENGTH_SHORT).show();
        }

        @Override //메뉴의 상태가 바뀌었을 때 이벤트 발생
        public void onDrawerStateChanged(int i) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOpen:
                mainDrawerLayout.openDrawer(drawMenu);
                break;
            case R.id.btnClose:
                mainDrawerLayout.closeDrawer(drawMenu);
                break;

        }//end of switch
    }//end of onClick


    @Override //drawMenu 를 터치했을 때 발생시키고자 하는 이벤트를 정의한다.
    public boolean onTouch(View v, MotionEvent event) {

        return true;
    }
}
