package com.example.hp.myfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu1, btnMenu2, btnMenu3, btnMenu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu1 = findViewById(R.id.btnMenu1);
        btnMenu2 = findViewById(R.id.btnMenu2);
        btnMenu3 = findViewById(R.id.btnMenu3);
        btnMenu4 = findViewById(R.id.btnMenu4);

        btnMenu1.setOnClickListener(this);
        btnMenu2.setOnClickListener(this);
        btnMenu3.setOnClickListener(this);
        btnMenu4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btnMenu1:
                fragment = new Fragment1Activity();
                break;
            case R.id.btnMenu2:
                fragment = new Fragment2Activity();
                break;
            case R.id.btnMenu3:
                fragment = new Fragment3Activity();
                break;
            case R.id.btnMenu4:
                fragment = new Fragment4Activity();
                break;
        }
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
