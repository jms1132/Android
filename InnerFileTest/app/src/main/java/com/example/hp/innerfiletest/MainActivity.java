package com.example.hp.innerfiletest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMemoryWrite, btnMemoryRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMemoryWrite = findViewById(R.id.btnMemoryWrite);
        btnMemoryRead = findViewById(R.id.btnMemoryRead);

        //1. 내부메모리에 파일 쓰기 기능
        btnMemoryWrite.setOnClickListener(this);

        //2. 내부메모리에 파일 읽기 기능
        btnMemoryRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMemoryWrite:
                fileInnerWrite();
                break;
            case R.id.btnMemoryRead:
                fileInnerRead();
                break;
        }
    }

    //1. 내부메모리에 파일 쓰기 기능
    private void fileInnerWrite() {
        try {
            FileOutputStream fos = openFileOutput("file.txt", Context.MODE_PRIVATE);
            String string = "꿀잼 안드로이드";
            fos.write(string.getBytes());
            fos.close();
            toastDisplay("file.txt가 잘 생성됨");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2. 내부메모리에 파일 읽기 기능
    private void fileInnerRead() {
        FileInputStream fis=null;
        try {
            fis = openFileInput("file.txt");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            toastDisplay(new String(data));
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //토스트 알림 주기
    private void toastDisplay(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
