package com.example.hp.fourbutton;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //1. 변수선언: 반드시 xml 화면의 위젯의 아이디와 일치시킬것
    Button btnNate, btnDear, btnGallery, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 화면객체를 찾아서 가져온다.(형변환)
        btnNate = (Button) findViewById(R.id.btnNate);
        btnDear = (Button) findViewById(R.id.btnDear);
        btnGallery = (Button) findViewById(R.id.btnGallery);
        btnExit = (Button) findViewById(R.id.btnExit);

        //3. 이벤트를 건다.
        btnNate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4. 인텐트 기술
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(intent); // 이 내용으로 새로운 화면을 보여달라는 요청의 의미
            }
        });

        btnDear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4. 인텐트 기술
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/010-3914-6562"));
                startActivity(intent); // 이 내용으로 새로운 화면을 보여달라는 요청의 의미
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4. 인텐트 기술
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(intent); // 이 내용으로 새로운 화면을 보여달라는 요청의 의미
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4. 인텐트 기술
                finish();
            }
        });

    }
}
