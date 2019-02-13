package com.articledemo.interfaces;

import android.os.Bundle;

/**
 * Interface for fragment callback and update
 */
public interface IFragmentCallback {
    enum FRAGMENT_TYPE {LIST,DETAIL};
    void onLoadFragment(FRAGMENT_TYPE type, Bundle extras);
    void onFragmentResult(String result, Object object);
}
