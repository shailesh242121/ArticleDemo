package com.articaldemo.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.articaldemo.R;
import com.articaldemo.interfaces.IFragmentCallback;
import com.articaldemo.network.model.Articles;
import com.articaldemo.ui.fragment.ArticleListFragment;
import com.articaldemo.ui.fragment.DetailFragment;

/**
 *  Main activity that hold both list and detail fragments
 */
public class MainActivity extends BaseActivity implements IFragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     *  initialize the activity
     */
    private void init() {
//        manager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//            @Override
//            public void onBackStackChanged() {
//                if(manager.getBackStackEntryCount() == 0)
//                    finish();
//            }
//        });
        loadFragment(R.id.fl_container,new ArticleListFragment(), true);

    }


    @Override
    public void onLoadFragment(FRAGMENT_TYPE type, Bundle extras) {
        Fragment mFragment = null;
          switch (type)
          {
              case DETAIL:
                  mFragment =new DetailFragment();
                  break;
          }

          if(mFragment!=null)
          {
              if(extras!=null)
                  mFragment.setArguments(extras);
              loadFragment(R.id.fl_container,mFragment,false);
          }
    }

    @Override
    public void onFragmentResult(String result, Object object) {
           switch (result)
           {
               case "detail":
                   Bundle mBundle = new Bundle();
                   Articles item = (Articles) object;
                   mBundle.putParcelable("article", item);
                   onLoadFragment(FRAGMENT_TYPE.DETAIL,mBundle);
                   break;
           }
    }
}
