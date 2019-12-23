package com.example.hp.mylistviewcreatertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<MyCustomDTO> list = new ArrayList<MyCustomDTO>();
        list.add(new MyCustomDTO(R.drawable.love_icon, "정민지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정수지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정회영", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "김미희", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정홍량", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정민지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정수지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정회영", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "김미희", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정홍량", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정민지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정수지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정회영", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "김미희", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정홍량", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정민지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정수지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정회영", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "김미희", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정홍량", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정민지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정수지", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정회영", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "김미희", "화이팅!", R.drawable.love_icon));
        list.add(new MyCustomDTO(R.drawable.love_icon, "정홍량", "화이팅!", R.drawable.love_icon));
        listView = findViewById(R.id.listView);


        MyCustomAdapter adapter = new MyCustomAdapter(getApplicationContext(), R.layout.list_row, list);


        listView.setAdapter(adapter);
    }
}
