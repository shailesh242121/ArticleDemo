package com.articledemo.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Common Network call class for all Network hit perpuse
 */
public class NetworkHit {

    /**
     *  Implement the retrofit a Squre library for network call
     */
    private static Retrofit retrofit = null;

    private NetworkHit()
    {

    }

    /**
     * singleton object
     */
    public static NetworkHit networkHit = new NetworkHit();

    /**
     *  Getting instance of Network hit
     * @return
     */
    public static NetworkHit getInstance()
    {
        return networkHit;
    }


    /**
     *  Get instance of APi Call
     * @return
     */
    public IApis getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(IApis.class);
    }


}
