package com.example.hp.practice11_3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Spinner posterSpinner;
    ImageView posterImage;

    final Integer[] posterID = {R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
            R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};

    final String[] movie = {"쿵푸팬더", "짱구는 못말려", "아저씨", "아바타", "대부", "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        posterImage = findViewById(R.id.posterImage);
        posterSpinner = findViewById(R.id.posterSpinner);

        MySpinnerAdapter spinAdapter = new MySpinnerAdapter(this);
        posterSpinner.setAdapter(spinAdapter);

        posterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posterImage.setImageResource(posterID[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private class MySpinnerAdapter extends BaseAdapter {

        Context context;


        public MySpinnerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.spinner_layout, null);

            TextView title = view.findViewById(R.id.title);
            title.setText(movie[position]);


            return view;


        }
    }
}
