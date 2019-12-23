package com.example.hp.singerdatabasemanagementtest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDBHelper myDBHelper;
    private EditText editName, editNumber, editNameResult, editNumberResult;
    private Button btnInit, btnInsert, btnSelect;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);
        editNameResult = findViewById(R.id.editNameResult);
        editNumberResult = findViewById(R.id.editNumberResult);
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        myDBHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(this);

        btnSelect.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInit:
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqLiteDatabase, 1, 2);
                //데이터베이스를 닫는다.
                sqLiteDatabase.close();
                break;
            case R.id.btnInsert:
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String str = "INSERT INTO groupTBL values ('" + editName.getText().toString().trim() + "'," + editNumber.getText().toString() + ");";
                sqLiteDatabase.execSQL(str);
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), editName.getText().toString() + " 입력됨", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", editName.getText().toString() + " 입력됨");
                break;
            case R.id.btnSelect:

                sqLiteDatabase = myDBHelper.getReadableDatabase();
                Cursor cursor; //recordSet
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                editNameResult.setText(strNames);
                editNumberResult.setText(strNumbers);
                cursor.close();
                sqLiteDatabase.close();
                break;

        }
    }
}

