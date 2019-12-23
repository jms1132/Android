package com.example.hp.practice4_4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switchStart;
    RadioGroup rGroup1;
    RadioButton rdoRolli, rdoMash, rdoNuga;
    Button btnExit;
    Button btnRestart;
    ImageView imgAndroid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 위젯을 변수에 대입
        text1 = (TextView) findViewById(R.id.Text1);
        switchStart = (Switch) findViewById(R.id.SwitchStart);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoRolli = (RadioButton) findViewById(R.id.RdoRolli);
        rdoMash = (RadioButton) findViewById(R.id.RdoMash);
        rdoNuga = (RadioButton) findViewById(R.id.RdoNuga);
        btnExit = (Button) findViewById(R.id.BtnExit);
        btnRestart = (Button) findViewById(R.id.BtnRestart);
        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);


        // 동의함 스위치박스가 변경되면
        switchStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                // 스위치박스가 on 되면 모두 보이도록 설정
                if (switchStart.isChecked()) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnExit.setVisibility(android.view.View.VISIBLE);
                    btnRestart.setVisibility(android.view.View.VISIBLE);
                    imgAndroid.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnExit.setVisibility(android.view.View.INVISIBLE);
                    btnRestart.setVisibility(android.view.View.INVISIBLE);
                    imgAndroid.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
        rdoMash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAndroid.setImageResource(R.drawable.mash);

            }
        });
        rdoNuga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAndroid.setImageResource(R.drawable.nuga);

            }
        });
        rdoRolli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAndroid.setImageResource(R.drawable.rolli);

            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchStart.setChecked(false);
                rdoMash.setChecked(false);
                rdoNuga.setChecked(false);
                rdoRolli.setChecked(false);


            }
        });
    }

}