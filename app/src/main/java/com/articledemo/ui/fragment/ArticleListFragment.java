package com.articledemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.articledemo.R;
import com.articledemo.adapter.ArticleAdapter;
import com.articledemo.helper.Tools;
import com.articledemo.interfaces.IRecyclerViewClick;
import com.articledemo.mvp.presenter.ArticleListPresenter;
import com.articledemo.mvp.view.ArticleView;
import com.articledemo.network.model.Articles;

import java.util.ArrayList;
import java.util.List;


/**
 *  Article list fragment
 */
public class ArticleListFragment extends BaseFragment implements ArticleView, IRecyclerViewClick,SwipeRefreshLayout.OnRefreshListener {

    /**
     * View of the fragment for not to load every time and can be use further
     */
    private View view;

    /**
     *  Recycler view to load article list and show
     */
    private RecyclerView rclArticleList;

    /**
     *  Activity indication while loading the data from network
     */
    private ProgressBar pgBar;

    /*
     Empty view if there is some error or No item on that network
     */
    private LinearLayout llEmpty;

    /**
     *  Refresh layout for pull to refresh the list at any point of time
     */
    private SwipeRefreshLayout refreshLayout;

    /**
     *  Presenter that will supply articles to list
     */
    private ArticleListPresenter presenter;
    /**
     *  Adapter to show the list content
     */
    private ArticleAdapter adapter;

    /**
     *  this is now fixed to 1 can have values 1 ,7 and 30 as how many older days of article you want to show
     */
    private int pageNumber = 1;

    /**
     *  list that hold the items
     */
    private List<Articles> mList = new ArrayList<>();




    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if(view ==null ) {
            view = inflater.inflate(R.layout.fragment_article_list, container, false);
            //  ButterKnife.bind(this, view);
            initFragment(view);
        }
        return view;
    }

    /**
     * initialize the fragment
     * @param view
     */
    private void initFragment(View view) {
        pgBar = view.findViewById(R.id.pgbar);
        rclArticleList = view.findViewById(R.id.rcl_article_list);
        llEmpty = view.findViewById(R.id.ll_empty);
        refreshLayout = view.findViewById(R.id.srl);
        refreshLayout.setOnRefreshListener(this);

        presenter = new ArticleListPresenter(this);
        rclArticleList.setLayoutManager(new LinearLayoutManager(mCtx, LinearLayout.VERTICAL, false));

        /*
         load article at very first time
         */
        loadArticles();
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    /**
     *  polls network to load articles
     */
    private void loadArticles() {
        presenter.loadArticles(pageNumber);
        if(!isReloading)
        pgBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onArticleLoaded(boolean success, List<Articles> mArticleList) {
        pgBar.setVisibility(View.GONE);
        if(isReloading)
        refreshLayout.setRefreshing(false);
        if (mArticleList != null && !mArticleList.isEmpty()) {
            llEmpty.setVisibility(View.GONE);
            mList.addAll(mArticleList);
            if (adapter == null || isReloading) {
                isReloading = false;
                adapter = new ArticleAdapter(mArticleList);
                adapter.setListener(this);
                rclArticleList.setAdapter(adapter);
            } else adapter.notifyDataSetChanged();
        }else
        {
            llEmpty.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onError(String error) {
        pgBar.setVisibility(View.GONE);
        Tools.showToast(mCtx, error);
        llEmpty.setVisibility(mList.isEmpty()?View.VISIBLE:View.GONE);
    }

    @Override
    public void onItemClick(int position, Object obj) {
       mCallback.onFragmentResult("detail",obj);
    }

    /**
     * it articles are loaded from pull to refresh then true else false
     */
    private boolean isReloading = false;

    @Override
    public void onRefresh() {
        pageNumber = 1;
        isReloading = true;
        loadArticles();
    }
}
