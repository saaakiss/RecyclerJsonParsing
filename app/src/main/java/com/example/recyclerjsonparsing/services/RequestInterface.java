package com.example.recyclerjsonparsing.services;

import com.example.recyclerjsonparsing.models.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sak on 05-Jul-17.
 */

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();

}
