package com.teknorial.retrofit2listview.rest;

import com.teknorial.retrofit2listview.models.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Teknorial on 10/02/2016.
 */
public interface RestAPI{

    @GET("example/buku")
    Call<Model> loadListBook();
}
