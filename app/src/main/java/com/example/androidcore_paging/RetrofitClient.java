package com.example.androidcore_paging;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Retrofit Client that will make API call.
 *  Should be Singleton.
 */

public class RetrofitClient {

    private static final String BASE_URL = "https://api.stackexchange.com/2.2" + "/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // Using ConverterFactory, we don't need to pass JSON manually.
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // To make class Singleton
    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getAPI(){
        return retrofit.create(Api.class);
    }
}
