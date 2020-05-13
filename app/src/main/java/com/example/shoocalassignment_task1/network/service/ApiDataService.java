package com.example.shoocalassignment_task1.network.service;

import com.example.shoocalassignment_task1.model.ApiData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {
    @GET("/repositories/19438/issues")
    Call<List<ApiData>> getData();
}
