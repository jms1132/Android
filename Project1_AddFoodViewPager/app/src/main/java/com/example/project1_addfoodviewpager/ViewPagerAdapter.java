package com.example.project1_addfoodviewpager;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //뷰페이저에서 프레그먼트 교체를 보여주는 역할을 한다.
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AddFood.newInstance();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Nullable
    @Override //상단의 탭 레이아웃 제목에 대한 텍스트를 선언하는 역할
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "야채";
            case 1:
                return "과일";
            case 2:
                return "육류";
            case 3:
                return "해산물";
            case 4:
                return "유제품";
            case 5:
                return "반찬";
            case 6:
                return "인스턴트";
            case 7:
                return "음료";
            case 8:
                return "양념";
            case 9:
                return "조미료";
            default:
                return null;
        }
    }
}
