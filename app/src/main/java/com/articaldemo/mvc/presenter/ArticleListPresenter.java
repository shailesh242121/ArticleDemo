package com.articaldemo.mvc.presenter;

import com.articaldemo.BuildConfig;
import com.articaldemo.mvc.view.ArticleView;
import com.articaldemo.network.Constants;
import com.articaldemo.network.NetworkHit;
import com.articaldemo.network.model.Articles;
import com.articaldemo.network.model.NetworkResponse;
import com.articaldemo.ui.fragment.ArticleListFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *   Presenter for ArticleList fragment
 */
public class ArticleListPresenter implements BasePresenter {

    /**
     * View for that fragment
     */
    private ArticleView view;

    public ArticleListPresenter(ArticleView view) {
        this.view = view;
    }

    /**
     *   Method call to load article list
     * @param pageNumber
     */
    public void loadArticles(int pageNumber)
    {
        // TODO Netowrk status check before call
        NetworkHit.getInstance().getClient().getArticles(String.valueOf(pageNumber), BuildConfig.API_KEY).enqueue(new Callback<NetworkResponse>() {
            @Override
            public void onResponse(Call<NetworkResponse> call, Response<NetworkResponse> response) {
                    if(response.isSuccessful())
                    {
                        view.onArticleLoaded(true,response.body().getResults());
                    }else
                        view.onError("Failed");
            }

            @Override
            public void onFailure(Call<NetworkResponse> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });

    }

    @Override
    public void onDestroy() {
  //TODO Remove all the assigned variable
    }


}
