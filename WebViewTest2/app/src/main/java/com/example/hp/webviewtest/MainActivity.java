package com.example.hp.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String stringUrl = "http://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        //webView 셋팅처리
        webView.getSettings().setJavaScriptEnabled(true);
        //webView 보여주기
        webView.loadUrl(stringUrl);
        //webView 를 크롬 브라우저로 셋팅
        webView.setWebChromeClient(new WebChromeClient());
        //클릭시 새창을 안뜨게 하기
        webView.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
        }
        return true;
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
