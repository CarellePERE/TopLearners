package com.example.toplearners.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static gadsapi sGads;
    private static Retrofit sRetrofit;

    private static Retrofit getRetrofit()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okhttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        sRetrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build();
        return sRetrofit;

    }

    public static gadsapi getGadsApi()
    {
        sGads = getRetrofit().create(gadsapi.class);
        return sGads;
    }
}
