package com.articledemo.mvp.presenter;

import com.articledemo.mvp.view.ArticleView;
import com.articledemo.network.model.Articles;

import org.junit.Test;

import java.util.List;

public class ArticleListPresenterTest {

    @Test
    public void loadArticles() {
        ArticleListPresenter presenter = new ArticleListPresenter(av);
        presenter.loadArticles(1);
    }

    @Test
    public void onDestroy() {
    }

    private ArticleView av = new ArticleView() {
        @Override
        public void onArticleLoaded(boolean success, List<Articles> mArticleList) {
             if(success)
              System.out.print(mArticleList.size());
             else
                 System.out.print("Failed to load");
        }

        @Override
        public void onError(String message) {
            System.out.print("Error while getting article "+ message);
        }
    };
}