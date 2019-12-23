package com.example.hp.practice7_3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName, editEmail;
    Button btnClickHere;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        btnClickHere = findViewById(R.id.btnClickHere);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = View.inflate(MainActivity.this, R.layout.dialog_activity, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("사용자 정보 입력");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setView(dialogView);

                final EditText editDialName = dialogView.findViewById(R.id.editDialName);
                final EditText editDialEmail = dialogView.findViewById(R.id.editDialEmail);

                editDialName.setText(editName.getText().toString().trim());
                editDialEmail.setText(editEmail.getText().toString().trim());

                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        editName.setText(editDialName.getText().toString().trim());
                        editEmail.setText(editDialEmail.getText().toString().trim());
                    }
                });
                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toastView = View.inflate(MainActivity.this, R.layout.toast_dialog, null);
                        Toast toast = new Toast(MainActivity.this);
                        toast.setView(toastView);
                        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                        int x= (int)(Math.random()*display.getWidth());
                        int y= (int)(Math.random()*display.getHeight());

                        toast.setGravity(Gravity.TOP|Gravity.LEFT, x,y);
                        toast.show();

                    }
                });
                dialog.show();
            }
        });
    }
}