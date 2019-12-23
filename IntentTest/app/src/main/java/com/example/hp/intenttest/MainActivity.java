package com.example.hp.intenttest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCal;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        btnCal = findViewById(R.id.btnCal);

        btnCal.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //명시적 인텐트 방법 = 값을 전달하지 않았다.
        Intent intent = new Intent(MainActivity.this, SubActivity.class);

        //명시적 인텐트 방법 = 값을 전달한다.
        intent.putExtra("number1", Integer.parseInt(editText.getText().toString().trim()));
        intent.putExtra("number2", Integer.parseInt(editText2.getText().toString().trim()));

        //requestCode
        startActivityForResult(intent, 1000);
        //startActivity(intent);
    }

    //상대방 액티비티 값을 다시 돌려주었을 때 감지하는 콜백함수
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent returnIntent) {
        super.onActivityResult(requestCode, resultCode, returnIntent);
        if (requestCode == 1000 && resultCode == 1001) {
            int sum = returnIntent.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + sum, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "이상한 값이에요", Toast.LENGTH_SHORT).show();

        }
    }
}
