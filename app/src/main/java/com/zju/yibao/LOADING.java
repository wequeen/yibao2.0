package com.zju.yibao;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

public class LOADING extends Activity {

    private static final int TIME = 2000;
    private static final int GO_HOME = 0x123;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    Intent intent = new Intent(LOADING.this, HOME.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        handler.sendEmptyMessageDelayed(GO_HOME, TIME);
    }
}
