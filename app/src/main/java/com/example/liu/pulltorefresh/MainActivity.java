package com.example.liu.pulltorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainActivity extends AppCompatActivity {
    private String[] urlString={"http://img5.duitang.com/uploads/item/201410/04/20141004141720_vr23M.jpeg",
    "http://img1.imgtn.bdimg.com/it/u=3724834980,466973059&fm=11&gp=0.jpg",
    "http://i2.hexunimg.cn/2015-04-07/174742774.jpg",
    "http://img1.imgtn.bdimg.com/it/u=2525689499,526305536&fm=21&gp=0.jpg"
};
    private PtrClassicFrameLayout ptr_pcf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ptr_pcf = (PtrClassicFrameLayout) findViewById(R.id.ptr_pcf);

        ptr_pcf.setPtrHandler(new PtrDefaultHandler() {

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                new Handler(new Handler.Callback() {

                    @Override
                    public boolean handleMessage(Message msg) {
                        //在这里做耗时操作，刷新完成时通知控件
                        
                        ptr_pcf.refreshComplete();
                        return false;
                    }
                }).sendEmptyMessageDelayed(0,2000);
            }
        });
    }
}
