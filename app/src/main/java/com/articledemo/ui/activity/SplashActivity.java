package com.articledemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.articledemo.R;

/**
 * Splash activity
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Put a delay of 3 Seconds to start main activity
        mHandler.sendEmptyMessageDelayed(100,3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeMessages(100);
    }

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 100)
            {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }
    };
}
