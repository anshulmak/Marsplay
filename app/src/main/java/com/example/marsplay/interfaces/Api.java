package com.example.marsplay.interfaces;

import com.example.marsplay.Models.response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.plos.org/";

    @GET("search?q=title:DNA")
    Call<response> getResponse();
}