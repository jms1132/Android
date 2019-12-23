package com.example.hp.practice8_15;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Button btnFileList;
EditText editFileList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFileList = findViewById(R.id.btnFileList);
        editFileList = findViewById(R.id.editFileList);

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles = (new File(sysDir).listFiles());


                String strFname;
                for(int i =0; i<sysFiles.length;i++){
                    if(sysFiles[i].isDirectory()==true){
                        strFname = "<폴더> " + sysFiles[i].toString();
                    }else{
                        strFname = "<파일> " + sysFiles[i].toString();
                    }
                    editFileList.setText(editFileList.getText()+"\n"+strFname);
                }
            }
        });
    }
}
