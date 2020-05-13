package com.example.shoocalassignment_task1.presenter;

import com.example.shoocalassignment_task1.model.ApiData;
import com.example.shoocalassignment_task1.network.service.ApiDataService;
import com.example.shoocalassignment_task1.view.SplashScreenView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenPresenter {
    private ApiDataService apiDataService;
    private SplashScreenView splashScreenView;

    public SplashScreenPresenter(ApiDataService apiDataService, SplashScreenView splashScreenView) {
        this.apiDataService = apiDataService;
        this.splashScreenView = splashScreenView;
    }

    public void makeApiRequest() {
        splashScreenView.showProgressBar();
        apiDataService.getData().enqueue(new Callback<List<ApiData>>() {
            @Override
            public void onResponse(Call<List<ApiData>> call, Response<List<ApiData>> response) {
                splashScreenView.hideProgressBar();
                if (response.isSuccessful()) {
                    List<ApiData> apiDataList = response.body();
                    splashScreenView.openNewActivity(apiDataList);
                    return;
                }
                splashScreenView.showError();
            }

            @Override
            public void onFailure(Call<List<ApiData>> call, Throwable t) {
                splashScreenView.hideProgressBar();
                splashScreenView.showError();
            }
        });
    }
}
