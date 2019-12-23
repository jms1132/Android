package com.example.hp.practice12_2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDBHelper myDBHelper;
    private EditText editName, editNumber;
    private Button btnInit, btnInsert, btnUpdate, btnDelete, btnSelect, btnSort;
    private SQLiteDatabase sqLiteDatabase;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MainAdapter mainAdapter;
    private ArrayList<MainData> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 총관리 DB TEST");

        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSelect = findViewById(R.id.btnSelect);
        btnSort = findViewById(R.id.btnSort);

        recyclerView = findViewById(R.id.recyclerView);
        myDBHelper = new MyDBHelper(this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        mainAdapter = new MainAdapter(MainActivity.this,R.layout.list_item, list);
        recyclerView.setAdapter(mainAdapter);


        btnInit.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        btnSort.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInit:
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqLiteDatabase, 1, 2);
                sqLiteDatabase.close();
                btnSelect.callOnClick();
                break;

            case R.id.btnInsert://execSQL = SELECT 명령을 제외한 모든 SQL 문장을 실행
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String str = "INSERT INTO testTBL values ('" + editName.getText().toString().trim() + "'," + editNumber.getText().toString() + ");";
                sqLiteDatabase.execSQL(str);
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), editName.getText().toString() + " 입력됨", Toast.LENGTH_SHORT).show();
                list.add(new MainData(editName.getText().toString(), editNumber.getText().toString()));

                btnSelect.callOnClick();
                break;

            case R.id.btnUpdate:
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String str1 = "UPDATE testTBL SET gNumber =" + editNumber.getText() + " WHERE gName = '" + editName.getText().toString() + "';";
                if (editName.getText().toString() != "") {
                    sqLiteDatabase.execSQL(str1);
                }
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), editName.getText().toString() + " 수정됨", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();

                break;

            case R.id.btnDelete:
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String str2 = "DELETE FROM testTBL WHERE gName = '" + editName.getText().toString() + "';";
                if (editName.getText().toString() != "") {
                    sqLiteDatabase.execSQL(str2);
                }
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), " 삭제됨", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();

                break;

            case R.id.btnSelect:
                recyclerView.removeAllViews();
                list.clear();
                //rawQuery = SELECT 명령어를 사용하여 쿼리를 실행하려면 rawQuery()를 사용하면 된다. 쿼리의 결과는 Cursor 객체로 반환된다.
                //Cursor 객체는 쿼리에 의하여 생성된 행들을 가리킨다.
                //Cursor는 DB에서 결과를 순회하고 데이터를 읽는 데 사용되는 표준적인 메커니즘이다.
                sqLiteDatabase = myDBHelper.getReadableDatabase();
                Cursor cursor; //recordSet
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM testTBL;", null);


                while (cursor.moveToNext()) {
                    String strName = cursor.getString(0);
                    String strNumber = cursor.getString(1);
                    list.add(new MainData(strName, strNumber));
                }

                mainAdapter.notifyDataSetChanged();

                cursor.close();
                sqLiteDatabase.close();
                break;
            case R.id.btnSort:
                recyclerView.removeAllViews();
                list.clear();
                //rawQuery = SELECT 명령어를 사용하여 쿼리를 실행하려면 rawQuery()를 사용하면 된다. 쿼리의 결과는 Cursor 객체로 반환된다.
                //Cursor 객체는 쿼리에 의하여 생성된 행들을 가리킨다.
                //Cursor는 DB에서 결과를 순회하고 데이터를 읽는 데 사용되는 표준적인 메커니즘이다.
                sqLiteDatabase = myDBHelper.getReadableDatabase();
                Cursor cursor1; //recordSet
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM testTBL order by gName;", null);


                while (cursor.moveToNext()) {
                    String strName = cursor.getString(0);
                    String strNumber = cursor.getString(1);
                    list.add(new MainData(strName, strNumber));
                }
                mainAdapter.notifyDataSetChanged();

                cursor.close();
                sqLiteDatabase.close();
                break;
        }
    }
}
