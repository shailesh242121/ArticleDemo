package com.articledemo.network;

import com.articledemo.network.model.NetworkResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * APi interface for all called apis over network
 */
public interface IApis {

    /**
     * Method for getting article
     *
     * @param period this showes the days past, to retrive the article
     * @param apikey secret key needed to proper authenticate the Network call
     * @return return the Callable function with Network response
     */
    @GET("viewed/{period}.json")
    Call<NetworkResponse> getArticles(@Path("period") String period, @Query("api-key") String apikey);
}
