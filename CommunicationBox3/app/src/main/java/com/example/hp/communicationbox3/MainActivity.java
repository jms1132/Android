package com.example.hp.communicationbox3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionList = new String[]{"마시멜로우", "누가", "롤리팝"};
                final boolean[] checkList = new boolean[]{true, false, false};
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("좋아하는 안드로이드 버전은?");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setMultiChoiceItems(versionList, checkList,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkList[which] = isChecked;
                            }
                        });

                dialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String choice = "";
                        for (int i = 0; i < checkList.length; i++) {
                            if (checkList[i]) {
                                choice += (versionList[i]+"\n");
                            }
                        }
                        txtView1.setText(choice);
                    }
                });
                dialog.show();
            }
        });
    }
}
