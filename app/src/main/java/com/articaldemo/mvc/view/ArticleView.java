package com.articaldemo.mvc.view;

import com.articaldemo.network.model.Articles;

import java.util.List;

/**
 *  View interface for supply data to UI class
 */
public interface ArticleView {
    /**
     *  When Article loaded
     * @param success boolean true if network call is successfull and having current data
     * @param mArticleList
     */
    void onArticleLoaded(boolean success, List<Articles> mArticleList);

    /**
     *  When an error comes while loading or getting data
     * @param message
     */
    void onError(String message);
}
