package com.example.hp.volleywebapphttptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvID, tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvID = findViewById(R.id.tvID);
        tvPassword = findViewById(R.id.tvPassword);

        // 로그인이 완료되면 이 화면을 불러준다.(ID, Password)
        // 회원가입 완료되면 이 화면을 불러준다.

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");

        tvID.setText(userID);
        tvPassword.setText(userPassword);
    }
}
