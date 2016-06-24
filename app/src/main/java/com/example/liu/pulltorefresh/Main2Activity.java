package com.example.liu.pulltorefresh;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private RelativeLayout rl_content_main2;
    private WebView webview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        rl_content_main2 = (RelativeLayout) findViewById(R.id.rl_content_main2);
        AssetManager assetManager = getAssets();
        try {
            String[] list = assetManager.list("file:///android_asset");
            Toast.makeText(Main2Activity.this,""+list,Toast.LENGTH_LONG).show();

            webview2 = (WebView) rl_content_main2.findViewById(R.id.webview2);
//            加载assets目录下HTML文件
            webview2.getSettings().setDefaultTextEncodingName("UTF-8");
            webview2.loadUrl("file:///android_asset/index.html");//不能解决中文乱码问题

            //webView_main.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);
            //webview2.getSettings().setJavaScriptEnabled(true);
            //webview2.setWebChromeClient(new WebChromeClient());支持运行特殊的javascript
            //webview2.setWebViewClient(new WebViewClient());当点击超链地址后不会新打开浏览器来访问，而是始终在本app中浏览页面
            //webview2.loadUrl("http://m.weather.com.cn/m/pn12/weather.htm?id=101010100T");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
