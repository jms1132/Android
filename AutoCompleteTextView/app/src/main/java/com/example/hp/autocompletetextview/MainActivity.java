package com.example.hp.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 문자열 배열을 만든다.
        String[] data = {"CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미",
                "Friends", "Fringe", "Lost"};
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);

        //***********지금부터 어렵다. 패턴을 인식해야 한다.***********
        //2. 동시에 여러개 선택할 수 있도록, 구분자를 연결한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setTokenizer(token);

        multiAutoCompleteTextView.setAdapter(adapter);
    }
}
