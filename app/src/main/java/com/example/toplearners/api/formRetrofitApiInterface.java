package com.example.toplearners.api;

import com.example.toplearners.model.post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface formRetrofitApiInterface {
    @POST("1FAIpQLSe-xFE-SRmPMfitLv0KYLoi7zACsQ1uwOeUy0cxvH_yqz0wXw/viewform?usp=sf_link")
    @FormUrlEncoded
    Call<post> savePost(@Field("entry.387898935") String firstName,
                        @Field("entry.891349355") String lastName,
                        @Field("entry.56921726") String emailAdress,
                        @Field("entry.399117685") String gitLink);
}
