package com.example.shoocalassignment_task1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shoocalassignment_task1.R;
import com.example.shoocalassignment_task1.model.ApiData;
import com.example.shoocalassignment_task1.network.ServiceBuilder;
import com.example.shoocalassignment_task1.network.service.ApiDataService;
import com.example.shoocalassignment_task1.presenter.SplashScreenPresenter;
import com.example.shoocalassignment_task1.view.SplashScreenView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends Activity implements SplashScreenView {
    private ProgressBar progressBar;
    private SplashScreenPresenter splashScreenPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);

        progressBar = findViewById(R.id.progress_bar_splash);
        splashScreenPresenter = new SplashScreenPresenter(ServiceBuilder.build(ApiDataService.class), this);

        splashScreenPresenter.makeApiRequest();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void openNewActivity(List<ApiData> apiDataList) {
        ArrayList<ApiData> list = new ArrayList<>(apiDataList);
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra("apiContent", list);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Unable to fetch data", Toast.LENGTH_LONG).show();
    }

}
