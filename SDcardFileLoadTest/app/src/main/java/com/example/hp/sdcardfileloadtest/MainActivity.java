package com.example.hp.sdcardfileloadtest;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnFileList;
    EditText edtFileList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnFileList = findViewById(R.id.btnFileList);
        edtFileList = findViewById(R.id.edtFileList);

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getRootDirectory().getAbsolutePath();
                File[] dirFile = (new File("/sdcard/android5ban")).listFiles();
                String strFileName = "";

                for (int i = 0; i < dirFile.length; i++) {
                    if (dirFile[i].isDirectory() == true) {
                        strFileName = "<Folder>" + dirFile[i].toString();
                    } else {
                        strFileName = "<File>" + dirFile[i].toString();

                    }

                    edtFileList.setText(edtFileList.getText() + "\n" + strFileName);
                }
            }
        });


    }
}
