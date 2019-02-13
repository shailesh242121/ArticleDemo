package com.articledemo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.articledemo.interfaces.IFragmentCallback;

/**
 *  Base activity have all common argument and method to supply activities
 */
public class BaseActivity extends AppCompatActivity {

    /**
     *  Fragment Manage instace to work on fragments
     */
    protected FragmentManager manager;
    /**
     * Context holder
     */
    private Context mCtx;

    /**
     *  Fragment callback to activity. That should register in side the activity if working with fragment
     */
    private IFragmentCallback mCallback;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager=  getSupportFragmentManager();
        mCtx = this;
        if(mCtx instanceof IFragmentCallback)
            mCallback = (IFragmentCallback) mCtx;
    }

    /**
     *  Change the fragment on the container
     * @param container this container will load the fragment
     * @param fragment fragment will be loaded on cointainer
     * @param isAdd if wish to add the fragment or false if replace
     */
    void loadFragment(int container, Fragment fragment, boolean isAdd) {
        if(fragment == null) return;
        FragmentTransaction tr = manager.beginTransaction();
        if(isAdd)
        tr.add(container,fragment);
        else {
            tr.replace(container, fragment, fragment.toString());
            tr.addToBackStack(fragment.toString());
        }

        tr.commit();
    }
}
