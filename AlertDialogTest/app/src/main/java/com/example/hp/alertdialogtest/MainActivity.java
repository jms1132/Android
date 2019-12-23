package com.example.hp.alertdialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("show Diaog");

        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("답변해 주세요.");
                dialog.setMessage("애인이 있나요?");
                dialog.setIcon(R.mipmap.love_icon);
                dialog.setPositiveButton("있어요.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "행복하세요오", Toast.LENGTH_LONG).show();
                        btnDialog.setText("햄볶");
                    }
                });
                dialog.setNegativeButton("없어요.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "유감....", Toast.LENGTH_LONG).show();
                        btnDialog.setText("쥬륵");
                    }
                });
                dialog.show();
            }
        });

    }

}
