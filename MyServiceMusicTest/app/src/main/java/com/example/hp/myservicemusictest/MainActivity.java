package com.example.hp.myservicemusictest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        intent = new Intent(this, MusicService.class);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                startService(intent);
                android.util.Log.i("MusicService", "startService()");                break;

            case R.id.btnStop:
                stopService(intent);
                android.util.Log.i("MusicService", "stopService()");                break;
        }
    }

    @Override
    protected void onDestroy() {
        stopService(intent);
        super.onDestroy();
    }
}