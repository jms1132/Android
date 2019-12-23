package com.example.hp.practice8_2;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPrevious, btnNext;
    MyPictureView myPictureView;
    File[] imageFiles;
    int currentPoint = 0;
    TextView tvNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        myPictureView = findViewById(R.id.myPictureView);
        tvNumber = findViewById(R.id.tvNumber);

        // 처음에 화면을 보여줘야 한다.
        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/pic").listFiles();


        myPictureView.setSrc(imageFiles[currentPoint].toString().trim());
        myPictureView.invalidate();
        tvNumber.setText("1" + "/" + imageFiles.length);

        String fileName = myPictureView.getSrc();
        Toast.makeText(getApplicationContext(),fileName,Toast.LENGTH_SHORT).show();

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrevious:
                imageChangePrevious();
                break;
            case R.id.btnNext:
                imageChangeNext();
                break;

        }
    }

    private void imageChangeNext() {
        currentPoint += 1;
        currentPoint = (currentPoint > imageFiles.length-1) ? (0) : (currentPoint);
        myPictureView.setSrc(imageFiles[currentPoint].toString());
        // 이미지 소스가 변경되었다. 즉시 다시 그려라. 라는 명령어!
        myPictureView.invalidate();
        tvNumber.setText((currentPoint + 1) + "/" + imageFiles.length);

        String fileName = myPictureView.getSrc();
        Toast.makeText(getApplicationContext(),fileName,Toast.LENGTH_SHORT).show();
    }

    private void imageChangePrevious() {
        currentPoint -= 1;
        currentPoint = (currentPoint < 0) ? (imageFiles.length-1) : (currentPoint);
        myPictureView.setSrc(imageFiles[currentPoint].toString());
        // 이미지 소스가 변경되었다. 즉시 다시 그려라. 라는 명령어!
        myPictureView.invalidate();
        tvNumber.setText((currentPoint + 1) + "/" + imageFiles.length);

        String fileName = myPictureView.getSrc();
        Toast.makeText(getApplicationContext(),fileName,Toast.LENGTH_SHORT).show();
    }
}