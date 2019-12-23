package com.example.hp.practice12_2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "groupDB";
    private static final int VERSION = 1;

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE testTBL(" + "gName CHAR(20) PRIMARY KEY," + "gNumber Integer);";
        db.execSQL(str);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS testTBL;");
        onCreate(db);
    }
}
