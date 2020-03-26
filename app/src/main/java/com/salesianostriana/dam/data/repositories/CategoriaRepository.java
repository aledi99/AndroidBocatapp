package com.salesianostriana.dam.data.repositories;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.salesianostriana.dam.MyApp;
import com.salesianostriana.dam.retrofit.service.AppService;
import com.salesianostriana.dam.retrofit.servicegenerator.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaRepository {

    AppService service;
    LiveData<List<String>> data;

    public CategoriaRepository() {
        service = ServiceGenerator.createService(AppService.class);
    }

    public LiveData<List<String>> getAllCategories() {
        final MutableLiveData<List<String>> data = new MutableLiveData<>();

        Call<List<String>> call = service.getCategories();

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    Toast.makeText(MyApp.getContext(), "API Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "External error", Toast.LENGTH_LONG).show();
            }
        });
        return data;
    }
}
