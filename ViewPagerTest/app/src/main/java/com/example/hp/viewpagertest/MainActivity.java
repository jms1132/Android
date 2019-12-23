package com.example.hp.viewpagertest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    //1. FragmentPagerAdapter 선언한다.
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        //1. 양식 1번
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
