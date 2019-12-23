package com.example.hp.mybroadcastbatterytest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivBattery;
    private TextView tvBattery;
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBattery = findViewById(R.id.ivBattery);
        tvBattery = findViewById(R.id.tvBattery);

        //브로드캐스트 리시버를 받고자하는 앱은 브로드캐스트 객체를 만들어야 한다.
        callBroadcastReceiver();

    }



    private void callBroadcastReceiver() {
        broadcastReceiver = new BroadcastReceiver() {
            //여기서 정보를 받음 -> 처리하면 됨
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                    int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                    tvBattery.setText("현재 충전량 : " + remain + "\n");

                    if (remain >= 90) {
                        ivBattery.setImageResource(R.drawable.battery_100);
                    } else if (remain >= 70) {
                        ivBattery.setImageResource(R.drawable.battery_80);
                    } else if (remain >= 50) {
                        ivBattery.setImageResource(R.drawable.battery_60);
                    } else if (remain >= 10) {
                        ivBattery.setImageResource(R.drawable.battery_20);
                    } else {
                        ivBattery.setImageResource(R.drawable.battery_0);
                    }

                    int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                    switch (plug) {
                        case 0:
                            tvBattery.append("전원 연결 : 안됨");
                            break;
                        case BatteryManager.BATTERY_PLUGGED_AC:
                            tvBattery.append("전원 연결 : 어댑터 연결됨");
                            break;
                        case BatteryManager.BATTERY_PLUGGED_USB:
                            tvBattery.append("전원 연결 : USB 연결됨");
                            break;
                    }

                }
            }
        };


    }

    //화면이 사라질 때 브로드캐스트 리시버기능을 해제한다.
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    //화면이 생성될 때 인텐트 필터를 생성하고 액션(Intent.ACTION_BATTERY_CHANGED)을 등록 리시버 기능을 설정한다.
    @Override
    protected void onResume() {
        super.onResume();
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        //리시버 기능을 설정한다.
        registerReceiver(broadcastReceiver, intentFilter);

    }

}
