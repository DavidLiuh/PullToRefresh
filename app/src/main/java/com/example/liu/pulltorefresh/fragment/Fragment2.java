package com.example.liu.pulltorefresh.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.liu.pulltorefresh.R;


public class Fragment2 extends Fragment {


    private String urlString="http://tv.sohu.com/";

    public Fragment2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment2,null,false);
        final WebView webView = (WebView) view.findViewById(R.id.webView);
        final WebSettings settings = webView.getSettings();
        //设置支持js
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //设置先不加载图片
                settings.setBlockNetworkImage(true);
            }
            //设置用webView来显示网页，而不是跳转到浏览器
            @Override
            public void onPageFinished(WebView view, String url) {
                //文字加载完后显示图片
                settings.setBlockNetworkImage(false);
            }
        });
        webView.loadUrl(urlString);
        return view;
    }




}
