package com.articledemo.mvp.presenter;

import com.articledemo.BuildConfig;
import com.articledemo.mvp.view.ArticleView;
import com.articledemo.network.NetworkHit;
import com.articledemo.network.model.NetworkResponse;

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
        //  Netowrk status check before call
        NetworkHit.getInstance().getClient().getArticles(String.valueOf(pageNumber), BuildConfig.API_KEY).enqueue(new Callback<NetworkResponse>() {
            @Override
            public void onResponse(Call<NetworkResponse> call, Response<NetworkResponse> response) {
                    if(response.isSuccessful())
                        view.onArticleLoaded(true,response.body().getResults());
                    else
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
  // Remove all the assigned variable
    }


}
