package com.example.hp.singerdatabasemanagementtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "groupDB";
    private static final int VERSION = 1;

    // 데이터베이스 생성
    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    // 테이블 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE groupTBL(" + "gName CHAR(20) PRIMARY KEY," + "gNumber Integer);";
        db.execSQL(str);
    }

    // 테이블 삭제하고 다시 생성함
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS groupTBL;");
        onCreate(db);
    }
}
