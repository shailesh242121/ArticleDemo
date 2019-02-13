package com.articaldemo.mvc.presenter;

import com.articaldemo.mvc.view.ArticleView;
import com.articaldemo.network.model.Articles;

import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;

import static org.junit.Assert.*;

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