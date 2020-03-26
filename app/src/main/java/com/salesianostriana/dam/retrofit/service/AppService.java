package com.salesianostriana.dam.retrofit.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {

    @GET("/api/categorias/")
    Call<List<String>> getCategories();
}
