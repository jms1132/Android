package com.example.hp.toastmovetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
               int x= (int)(Math.random()*display.getWidth());
               int y= (int)(Math.random()*display.getHeight());
               Toast toast=Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.TOP|Gravity.LEFT, x,y);
                toast.show();
        }
        });

    }
}
