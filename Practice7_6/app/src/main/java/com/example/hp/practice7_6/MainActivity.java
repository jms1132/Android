package com.example.hp.practice7_6;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnShowImg;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup=findViewById(R.id.radioGroup);
        btnShowImg=findViewById(R.id.btnShowImg);

        btnShowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = View.inflate(MainActivity.this, R.layout.dialog_activity, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(dialogView);

                ImageView imageView = dialogView.findViewById(R.id.imageView);

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.dog:
                        imageView.setImageResource(R.drawable.dog);
                       dialog.setTitle("강아지");
                        break;
                    case R.id.rabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        dialog.setTitle("토끼");

                        break;
                    case R.id.cat:
                        imageView.setImageResource(R.drawable.cat);
                        dialog.setTitle("고양이");

                        break;
                }
                dialog.setNegativeButton("닫기", null);

                dialog.show();


            }
        });
    }
}
