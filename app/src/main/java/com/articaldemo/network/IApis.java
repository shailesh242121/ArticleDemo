package com.articaldemo.network;

import com.articaldemo.network.model.Articles;
import com.articaldemo.network.model.NetworkResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 *  APi interface for all called apis over network
 */
public interface IApis {

    /**
     *  Method for getting article
     *
     * @param period this showes the days past, to retrive the article
     * @param apikey secret key needed to proper authenticate the Network call
     * @return return the Callable function with Network response
     */
    @GET("viewed/{period}.json")
    Call<NetworkResponse> getArticles(@Path("period")String period,@Query("api-key") String apikey);
}
