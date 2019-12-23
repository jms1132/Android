package com.example.project1;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AddFood extends Fragment {

    private TextView textView;
    private View view;

    //뷰페이저를 통해서 슬라이딩이나 탭키를 눌러서 뷰페이저 프레그먼트가 변경이 되려면,
    //이 현재 프레그먼트 상태를 저장하는 변수가 필요하다.

    public static AddFood newInstance(){
        AddFood addFood = new AddFood(); //싱글톤과 같은 기능
        return addFood;
    }
    @Nullable
    @Override //onCreate() 와 같은 기능을 한다. // 자동으로 콜백함수처럼 불러지게 된다.
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.add_food, container, false);
        textView = view.findViewById(R.id.textView);


        return view;
}

    public class AddFoodViewPagerAdapter extends FragmentPagerAdapter {

        public AddFoodViewPagerAdapter(FragmentManager fm) {
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
}
