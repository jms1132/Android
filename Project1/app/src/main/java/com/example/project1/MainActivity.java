package com.example.project1;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class

MainActivity extends AppCompatActivity implements Main3.OnFragmentInteractionListener{
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Main1 main1;
    private Main2 main2;
    private Main3 main3;
    private Main4 main4;
    private Main5 main5;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomMenu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_1:
                        setFragment(0);

                        break;
                    case R.id.action_2:
                        setFragment(1);
                        main2.setArguments(bundle);

                        break;
                    case R.id.action_3:
                        setFragment(2);
                        break;
                    case R.id.action_4:
                        setFragment(3);
                        break;
                    case R.id.action_5:
                        setFragment(4);
                        break;
                }
                return true;

            }
        });
        main1 = new Main1();
        main2 = new Main2();
        main3 = new Main3();
        main4 = new Main4();
        main5 = new Main5();
        setFragment(0);

    }
    private void setFragment(int i) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case 0:
                fragmentTransaction.replace(R.id.frameLayout, main1);
                fragmentTransaction.commit();
                // commit() : 이게 반영되게끔 확정 지어주는 역할
                break;
            case 1:
                fragmentTransaction.replace(R.id.frameLayout, main2);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.frameLayout, main3);
                fragmentTransaction.commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.frameLayout, main4);
                fragmentTransaction.commit();
                break;
            case 4:
                fragmentTransaction.replace(R.id.frameLayout, main5);
                fragmentTransaction.commit();
                break;
        }

    }

    @Override
    public void onFragmentInteraction(Bundle bundle) { // 값이 매개변수로 전달되어 올 것!
        this.bundle = bundle;
        bottomNavigationView.setSelectedItemId(R.id.action_2);
    }


}