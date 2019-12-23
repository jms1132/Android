package com.example.hp.practice8_13;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMake, btnDelete;
    String strSDpath;
    File myDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnMake = findViewById(R.id.btnMake);
        btnDelete = findViewById(R.id.btnDelete);

        strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        myDir = new File(strSDpath + "/mydir");

        btnDelete.setOnClickListener(this);
        btnMake.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMake:

                if (myDir.exists()) {
                    Toast.makeText(getApplicationContext(), "디렉토리 이미 있잖아...",
                            Toast.LENGTH_SHORT).show();
                } else {
                    myDir.mkdir();
                    Toast.makeText(getApplicationContext(), "디렉토리가 만들어졌어용",
                            Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btnDelete:

                if (myDir.exists()) {
                    myDir.delete();
                    Toast.makeText(getApplicationContext(), "디렉토리가 삭제됬어용",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "삭제할 디렉토리가 없는데..?",
                            Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
