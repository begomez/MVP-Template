package com.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {



    @GET("/")
    public Call<Integer> getData();

}
