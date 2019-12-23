package com.example.project1_addfoodviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //1. FragmentPagerAdapter 선언한다.
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        //1. 양식 1번
        fragmentPagerAdapter = new AddFoodViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}