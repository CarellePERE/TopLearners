package com.example.toplearners.api;

import com.example.toplearners.model.learners;
import com.example.toplearners.model.skilliq;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface gadsapi {
    @GET("api/hours")
    Call<List<learners>> getAllUsers();
    @GET("api/skilliq")
    Call<List<skilliq>> getAlliq();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
