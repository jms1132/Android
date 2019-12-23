package com.example.hp.communicationbox1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView1 = (TextView)findViewById(R.id.txtView1);
        txtView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionList = new String[]{"마시멜로우", "누가", "롤리팝"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("좋아하는 안드로이드 버전은?");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setItems(versionList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtView1.setText(versionList[which]);
                    }
                });
                dialog.setNegativeButton("닫기", null);
                dialog.show();
            }
        });
    }
}
