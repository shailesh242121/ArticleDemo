package com.articledemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.articledemo.R;

/**
 * Splash activity
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Put a delay of 3 Seconds to start main activity
        mHandlerCallback.sendEmptyMessageDelayed(100,3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandlerCallback.removeMessages(100);
    }

    private Handler mHandlerCallback = new Handler()
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
