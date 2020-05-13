package com.example.shoocalassignment_task1.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoocalassignment_task1.R;
import com.example.shoocalassignment_task1.adapter.DashboardAdapter;
import com.example.shoocalassignment_task1.model.ApiData;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ArrayList<ApiData> apiContent = (ArrayList<ApiData>) getIntent().getSerializableExtra("apiContent");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        DashboardAdapter dashboardAdapter = new DashboardAdapter(apiContent);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dashboardAdapter);
    }
}
