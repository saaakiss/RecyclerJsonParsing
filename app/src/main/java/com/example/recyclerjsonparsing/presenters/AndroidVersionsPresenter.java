package com.example.recyclerjsonparsing.presenters;

import android.util.Log;

import com.example.recyclerjsonparsing.adapters.DataAdapter;
import com.example.recyclerjsonparsing.contracts.AndroidVersionContract;
import com.example.recyclerjsonparsing.models.AndroidVersion;
import com.example.recyclerjsonparsing.models.JSONResponse;
import com.example.recyclerjsonparsing.services.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sak on 06-Jul-17.
 */

public class AndroidVersionsPresenter implements AndroidVersionContract.Actions {

    private AndroidVersionContract.View mView;
    private ArrayList<AndroidVersion> data;

    public AndroidVersionsPresenter(AndroidVersionContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getAndroidVersions() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = requestInterface.getJSON();
        call.enqueue(new Callback<JSONResponse>() {

            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                parseJSONResponse(jsonResponse);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                mView.showError();
            }
        });
    }

    @Override
    public void parseJSONResponse(JSONResponse jsonResponse) {
        data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
        mView.showAndroidVersion(data);
    }

}
