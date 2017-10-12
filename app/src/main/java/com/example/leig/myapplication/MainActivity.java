package com.example.leig.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.yhcloud.netty.ConfigBean;
import cn.com.yhcloud.netty.NettyServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigBean configBean = new ConfigBean();

        configBean.setServicePort(8099);
        configBean.setMaxAllIdleTimeSeconds(30);
        configBean.setMaxReadIdleTimeSeconds(10);
        configBean.setMaxWriteIdleTimeSeconds(20);
        configBean.setSocketRecvBufferSize(65535);
        configBean.setSocketSendBufferSize(65535);

        new NettyServer(configBean).startService();
    }
}
