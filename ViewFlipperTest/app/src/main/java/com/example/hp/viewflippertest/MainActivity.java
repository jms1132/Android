package com.example.hp.viewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

        Button btnBefore, btnNext;
        ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBefore = findViewById(R.id.btnBefore);
        btnNext = findViewById(R.id.btnNext);
        viewFlipper = findViewById(R.id.viewFlipper);

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
    }
}
