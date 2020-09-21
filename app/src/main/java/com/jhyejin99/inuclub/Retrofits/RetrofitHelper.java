package com.jhyejin99.inuclub.Retrofits;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHelper {
    private String BASE_URL = "http://117.16.231.66:7001";
    public static RetrofitService create()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitService.class);
    }
}
