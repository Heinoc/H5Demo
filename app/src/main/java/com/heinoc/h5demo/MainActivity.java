package com.heinoc.h5demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        webView = findViewById(R.id.webview);



        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                Log.d("WebView", "onPageFinished");

                String js = "var newscript = document.createElement(\"script\");";
                js += "newscript.src=\"http://apidoc.star-media.cn/a.js\";";
                js += "document.body.appendChild(newscript);";

                view.loadUrl("javascript:" + js);


            }
        });

        webView.loadUrl("https://m.baidu.com/s?word=abc&sasub=gh_icon20190213");


    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}
