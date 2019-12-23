package com.example.hp.listviewgetstringtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {
    private ListView listView;
    private ArrayList<String> arrayData = new ArrayList<String>();

    private Button btnAdd;
    private EditText editText;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editData);

        //4번 = 자료제공 데이터 완성이 되었음.
        arrayDataInput();

        //5번 = 정의되어 있는 어뎁터를 사용한다.(방식 설정)
        adapter = new ArrayAdapter<String>(this,
                //2번 DataView 제공
                android.R.layout.simple_list_item_multiple_choice, arrayData);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        //이벤트 처리
        listView.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    private void arrayDataInput() {
        String[] name = {"정민지", "안소영", "김소진", "유세미", "심재현", "김지혜", "김성민", "남채현", "강윤해"};
        for (String data : name) {
            arrayData.add(data);
        }
        return;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = view.findViewById(android.R.id.text1);
        Toast.makeText(getApplicationContext(), "클릭됬어요", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "위치 i=+" + i + " l=" + l + " 데이터= " + arrayData.get(i) + " 진짜 객체에서 가져오는 값= " + textView.getText().toString());
    }

    @Override
    public void onClick(View v) {
        arrayData.add(editText.getText().toString().trim());
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), editText.getText().toString() + " 추가됬어요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
        String str = arrayData.get(i);
        arrayData.remove(i);
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), str + " 삭제되었어요", Toast.LENGTH_SHORT).show();

        return false;
    }
}

