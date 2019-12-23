package com.example.hp.assignment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSignUp, btnSignIn;

    View signInView, signUpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        final TextView txtView = findViewById(R.id.txtView);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpView = View.inflate(MainActivity.this, R.layout.signup_activity, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(signUpView);

                final EditText signUpId = signUpView.findViewById(R.id.signUpId);
                EditText signUpPassword = signUpView.findViewById(R.id.signUpPassword);
                final EditText signUpName = signUpView.findViewById(R.id.signUpName);


                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소된다", Toast.LENGTH_LONG).show();

                    }
                });
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtView.setText(signUpId.getText().toString() + "\n" + signUpName.getText().toString());
                    }
                });
                dialog.show();

            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInView = View.inflate(MainActivity.this, R.layout.signin_activity, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(signInView);

                final EditText signInId = signInView.findViewById(R.id.signInId);
                final EditText signInPassword = signInView.findViewById(R.id.signInPassword);

                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소된다", Toast.LENGTH_LONG).show();

                    }
                });
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (signInId.getText().toString().equals("ㅎ") && signInPassword.getText().toString().equals("ㅎ")) {
                            txtView.setText(signInId.getText().toString() + "님 ㅎㅇ");
                        } else {
                            txtView.setText("님 뭐함");
                        }
                    }
                });
                dialog.show();


            }
        });
    }
}
