package com.example.hp.navigationfragmentlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout mainDrawerLayout;
    LinearLayout drawMenu;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDrawerLayout = findViewById(R.id.mainDrawerLayout);
        drawMenu = findViewById(R.id.drawMenu);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch(v.getId()){
            case R.id.btn1:  fragment = new Fragment1Activity();break;
            case R.id.btn2:  fragment = new Fragment2Activity();break;
            case R.id.btn3:  fragment = new Fragment3Activity();break;
            case R.id.btn4:  fragment = new Fragment4Activity();break;
        }
        fragmentTransaction.replace(R.id.linearLayout, fragment);
        fragmentTransaction.commit();
    }
}
