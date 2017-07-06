package com.example.recyclerjsonparsing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerjsonparsing.contracts.AndroidVersionContract;
import com.example.recyclerjsonparsing.models.AndroidVersion;
import com.example.recyclerjsonparsing.adapters.DataAdapter;
import com.example.recyclerjsonparsing.models.JSONResponse;
import com.example.recyclerjsonparsing.R;
import com.example.recyclerjsonparsing.presenters.AndroidVersionsPresenter;
import com.example.recyclerjsonparsing.services.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityMain extends AppCompatActivity implements AndroidVersionContract.View {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;

    private AndroidVersionContract.Actions mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new AndroidVersionsPresenter(this);
        mPresenter.getAndroidVersions();

    }

    @Override
    public void showAndroidVersion(ArrayList<AndroidVersion> data) {
        dataAdapter = new DataAdapter(data);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_cardView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dataAdapter);

    }

    @Override
    public void showError() {

    }

}
