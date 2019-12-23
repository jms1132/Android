package com.example.hp.framelayoutpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button[] button = new Button[3];
    int[] valueID = {R.id.btnScreen1, R.id.btnScreen2, R.id.btnScreen3};
    LinearLayout layout1, layout2, layout3;

    Button txtBtn1, txtBtn2, txtBtn3;
    EditText editText1, editText2, editText3;
    String txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        txtBtn1 = findViewById(R.id.txtBtn1);
        txtBtn2 = findViewById(R.id.txtBtn2);
        txtBtn3 = findViewById(R.id.txtBtn3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        for (int i = 0; i < valueID.length; i++) {
            final int index = i;
            button[index] = findViewById(valueID[i]);
            button[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (index) {
                        case 0:
                            layout1.setVisibility(View.VISIBLE);
                            layout2.setVisibility(View.INVISIBLE);
                            layout3.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            layout1.setVisibility(View.INVISIBLE);
                            layout2.setVisibility(View.VISIBLE);
                            layout3.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            layout1.setVisibility(View.INVISIBLE);
                            layout2.setVisibility(View.INVISIBLE);
                            layout3.setVisibility(View.VISIBLE);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        txtBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1 = editText1.getText().toString();
                Toast.makeText(getApplicationContext(), txt1, Toast.LENGTH_LONG).show();
            }
        });
        txtBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1 = editText2.getText().toString();
                Toast.makeText(getApplicationContext(), txt2, Toast.LENGTH_LONG).show();
            }
        });
        txtBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1 = editText3.getText().toString();
                Toast.makeText(getApplicationContext(), txt3, Toast.LENGTH_LONG).show();
            }
        });
    }
}