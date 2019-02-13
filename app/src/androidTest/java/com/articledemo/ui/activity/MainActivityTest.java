package com.articledemo.ui.activity;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule rule = new ActivityTestRule(MainActivity.class);

    @Test
    public void onLoadFragment() {
        rule.launchActivity(new Intent());
    }

    @Test
    public void onFragmentResult() {
    }
}