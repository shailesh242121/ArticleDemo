package com.articledemo.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.articledemo.R;
import com.articledemo.helper.Tools;
import com.articledemo.interfaces.IFragmentCallback;
import com.articledemo.network.model.Articles;
import com.articledemo.ui.fragment.ArticleListFragment;
import com.articledemo.ui.fragment.DetailFragment;

/**
 * Main activity that hold both list and detail fragments
 */
public class MainActivity extends AppCompatActivity implements IFragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * initialize the activity
     */
    private void init() {
        loadFragment(R.id.fl_container, new ArticleListFragment(), true);
    }


    @Override
    public void onLoadFragment(FRAGMENT_TYPE type, Bundle extras) {
        Fragment mFragment = null;
        if(type == FRAGMENT_TYPE.DETAIL) {
                mFragment = new DetailFragment();
        }

        if (mFragment != null) {
            if (extras != null)
                mFragment.setArguments(extras);
            loadFragment(R.id.fl_container, mFragment, false);
        }
    }

    @Override
    public void onFragmentResult(String result, Object object) {
        if ("detail".equals(result)) {
            Bundle mBundle = new Bundle();
            Articles item = (Articles) object;
            mBundle.putParcelable("article", item);
            onLoadFragment(FRAGMENT_TYPE.DETAIL, mBundle);

        } else {
            Tools.showToast(MainActivity.this, "Not implemented");


        }
    }

        /**
     * Change the fragment on the container
     *
     * @param container this container will load the fragment
     * @param fragment  fragment will be loaded on cointainer
     * @param isAdd     if wish to add the fragment or false if replace
     */
    void loadFragment(int container, Fragment fragment, boolean isAdd) {
        if (fragment == null) return;
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        if (isAdd)
            tr.add(container, fragment);
        else {
            tr.replace(container, fragment, fragment.toString());
            tr.addToBackStack(fragment.toString());
        }
        tr.commit();
    }
}
