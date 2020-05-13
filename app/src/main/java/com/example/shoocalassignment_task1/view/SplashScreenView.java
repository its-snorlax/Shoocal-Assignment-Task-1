package com.example.shoocalassignment_task1.view;

import com.example.shoocalassignment_task1.model.ApiData;

import java.util.List;

public interface SplashScreenView {
    void openNewActivity(List<ApiData> apiDataList);

    void showError();
}
