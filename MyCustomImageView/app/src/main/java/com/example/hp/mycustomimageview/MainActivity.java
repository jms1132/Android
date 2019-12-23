package com.example.hp.mycustomimageview;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPrevious, btnNext;
    MyPictureView myPictureView;
    File[] imageFiles;
    int currenPoint = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        myPictureView = findViewById(R.id.myPictureView);

        // 처음에 화면을 보여줘야 한다.
        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/pic").listFiles();


        myPictureView.setSrc(imageFiles[currenPoint].toString().trim());
        myPictureView.invalidate();


        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrevious:
                imageChangePrevious();
                break;
            case R.id.btnNext: imageChangeNext();
                break;

        }
    }

    private void imageChangeNext() {
        currenPoint += 1;
        currenPoint = (currenPoint > 5) ? (0) : (currenPoint);
        myPictureView.setSrc(imageFiles[currenPoint].toString());
        // 이미지 소스가 변경되었다. 즉시 다시 그려라. 라는 명령어!
        myPictureView.invalidate();
    }

    private void imageChangePrevious() {
        currenPoint -= 1;
        currenPoint = (currenPoint < 0) ? (5) : (currenPoint);
        myPictureView.setSrc(imageFiles[currenPoint].toString());
        // 이미지 소스가 변경되었다. 즉시 다시 그려라. 라는 명령어!
        myPictureView.invalidate();
    }
}
