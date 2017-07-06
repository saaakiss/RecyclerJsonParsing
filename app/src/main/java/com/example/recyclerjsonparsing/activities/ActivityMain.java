package com.example.recyclerjsonparsing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.recyclerjsonparsing.contracts.AndroidVersionContract;
import com.example.recyclerjsonparsing.extra.Utilities;
import com.example.recyclerjsonparsing.interfaces.RecyclerClickListener;
import com.example.recyclerjsonparsing.models.AndroidVersion;
import com.example.recyclerjsonparsing.adapters.DataAdapter;
import com.example.recyclerjsonparsing.models.JSONResponse;
import com.example.recyclerjsonparsing.R;
import com.example.recyclerjsonparsing.presenters.AndroidVersionsPresenter;
import com.example.recyclerjsonparsing.services.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityMain extends AppCompatActivity implements AndroidVersionContract.View, RecyclerClickListener {

    private static final String ANDROID_VERSN = "Android Version";

    private DataAdapter dataAdapter;
    private AndroidVersionContract.Actions mPresenter;

    @BindView(R.id.recyclerView_cardView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mPresenter = new AndroidVersionsPresenter(this);

        if (Utilities.isNetworkAvailable(this)){
            progressBar.setVisibility(View.VISIBLE);
            mPresenter.getAndroidVersions();
        }
        else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, getString(R.string.error_connection) , Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showAndroidVersion(List<AndroidVersion> data) {
        progressBar.setVisibility(View.GONE);
        dataAdapter = new DataAdapter(data, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void showError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, getString(R.string.error_occured), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(Object object) {
        Intent intent = new Intent(this, ActivityAndroidVersionInfo.class);
        intent.putExtra(ANDROID_VERSN, (AndroidVersion) object);
        startActivity(intent);
    }
}
