package com.example.hp.nugaandorea;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editMessage;
    Button btnPrint, btnHome;
    RadioButton rdoBokSun1, rdoBokSun2;
    ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 응용프로그램");

        editMessage = findViewById(R.id.editMessage);
        btnPrint = findViewById(R.id.btnPrint);
        btnHome = findViewById(R.id.btnHome);
        rdoBokSun1 = findViewById(R.id.rdoBokSun1);
        rdoBokSun2 = findViewById(R.id.rdoBokSun2);
        ivShow = findViewById(R.id.ivShow);

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editMessage.getText().toString().trim();
                toastDisplay(message);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "http://"+editMessage.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(message));
                startActivity(intent);
            }
        });

        rdoBokSun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ivShow.setImageResource(R.drawable.boksun);
            }
        });

        rdoBokSun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShow.setImageResource(R.drawable.boksun2);
            }
        });
    }//end of onCreate

    public void toastDisplay(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();


    }
}
