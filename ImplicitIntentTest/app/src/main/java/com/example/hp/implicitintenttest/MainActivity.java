package com.example.hp.implicitintenttest;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDial, btnHome, btnGoogleMap, btnGoogleSearch, btnPhoto, btnSms, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("MainActivity","onCreate()");

        btnDial = findViewById(R.id.btnDial);
        btnHome = findViewById(R.id.btnHome);
        btnGoogleMap = findViewById(R.id.btnGoogleMap);
        btnGoogleSearch = findViewById(R.id.btnGoogleSearch);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnSms = findViewById(R.id.btnSms);
        btnExit = findViewById(R.id.btnExit);


        btnDial.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnGoogleMap.setOnClickListener(this);
        btnGoogleSearch.setOnClickListener(this);
        btnPhoto.setOnClickListener(this);
        btnSms.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume()");
    }



    //

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy()");
    }

    @Override
    public void onClick(View v) {
        Uri uri = null;
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnDial:
                uri = Uri.parse("tel:01092547942");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;

            case R.id.btnHome:
                uri = Uri.parse("http://www.naver.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.btnGoogleMap:
                uri = Uri.parse("http://maps.google.com/maps?q=" + 37.562228 + "," + 127.035162);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.btnGoogleSearch:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "팔당댐 카페");
                startActivity(intent);
                break;

            case R.id.btnPhoto:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;

            case R.id.btnSms:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "보고시퍼");
                intent.setData(Uri.parse("smsto:" + Uri.encode("01092547942")));
                startActivity(intent);
                break;
            case R.id.btnExit:
                finish();
                break;

        }
    }
}
