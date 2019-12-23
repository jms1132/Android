package com.example.hp.practice8_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editDiary;
    Button btnEdit, btnSave, btnExit;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("막 만든 다이어리");

        datePicker = findViewById(R.id.datePicker);
        editDiary = findViewById(R.id.editDiary);

        btnEdit = findViewById(R.id.btnEdit);
        btnSave = findViewById(R.id.btnSave);
        btnExit = findViewById(R.id.btnExit);


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        fileName = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + ".txt";

        String record = readDiary(fileName);
        editDiary.setText(record);


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {


            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear) + "_" + Integer.toString(dayOfMonth) + ".txt";

                String record = readDiary(fileName);
                editDiary.setText(record);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장됬어요.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 수정됬어요.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();

            btnEdit.setEnabled(true);
            btnSave.setEnabled(false);
        } catch (IOException e) {
            editDiary.setHint("일기 없음");
            btnEdit.setEnabled(false);
            btnSave.setEnabled(true);
        }
        return diaryStr;
    }
}

