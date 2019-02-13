package com.articledemo.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.articledemo.interfaces.IFragmentCallback;

/**
 * Base fragment from all fragments of the app
 */
public class BaseFragment extends Fragment {


    /**
     * Context of the attached activity
     */
    protected Context mCtx;
    /**
     *  Fragment call back
     *   if Activity is implemented IFragmentCallback
     *   else it will be null
     *
     *   Caution to check for null before use
     */
    protected IFragmentCallback mCallback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCtx = context;
        if(mCtx instanceof IFragmentCallback)
            mCallback = (IFragmentCallback) context;
    }
}
