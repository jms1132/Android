package com.example.hp.practice11_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private GridView gridView;
private ArrayList<MyData> list = new ArrayList<MyData>();
private MyGridAdapter myGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화포스터");

        gridView = findViewById(R.id.gridView);

        listInsertData();
        myGridAdapter = new MyGridAdapter(this, R.layout.image_vie_layout, list);
        gridView.setAdapter(myGridAdapter);
    }

    private void listInsertData() {
        Integer[] posterID = {
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

        for (int i = 0; i < 30; i++) {
            list.add(new MyData(posterID[(int) (Math.random() * (10))]));
        }


    }
}
