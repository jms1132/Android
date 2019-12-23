package com.example.hp.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editURL;
    Button btnMove, btnBack;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editURL = findViewById(R.id.editURL);
        btnMove = findViewById(R.id.btnMove);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);

        //1. 웹뷰를 실행하려면 WebViewClient 클래스를 상속을 받아서
        //shouldOverrideUrlLoading 을 진행해야 한다.
        webView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);



        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://"+editURL.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }


    }
}
