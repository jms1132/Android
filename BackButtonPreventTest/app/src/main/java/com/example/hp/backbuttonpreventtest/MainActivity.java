package com.example.hp.backbuttonpreventtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backButtonTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        long getTime = currentTime - backButtonTime;

        if (getTime >= 0 && getTime <= 2000) {
            super.onBackPressed();
        } else {
            backButtonTime = currentTime;
            Toast.makeText(this, "2초 이내에 한번 더 누르면 나간다잉"+currentTime, Toast.LENGTH_SHORT).show();
        }
    }
}
