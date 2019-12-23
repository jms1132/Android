package com.example.hp.volleywebapphttptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtID, edtPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtID = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String userID = edtID.getText().toString().trim();
        String userPassword = edtPassword.getText().toString().trim();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success) {
                        String userID = jsonObject.getString("userID");
                        String userPassword = jsonObject.getString("userPassword");
                        String userName = jsonObject.getString("userName");
                        String userAge = jsonObject.getString("userAge");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        intent.putExtra("userID", userID);
                        intent.putExtra("userPassword", userPassword);
                        intent.putExtra("userName", userName);
                        intent.putExtra("userAge", userAge);

                        startActivity(intent);
                        toastDisplay("로그인 성공햇다능:)");
                    } else {
                        toastDisplay("로그인 실패햇다능:(");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);
    }

    private void toastDisplay(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

