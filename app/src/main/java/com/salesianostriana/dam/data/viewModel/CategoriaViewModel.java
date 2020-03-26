package com.salesianostriana.dam.data.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.salesianostriana.dam.data.repositories.CategoriaRepository;

import java.util.List;

public class CategoriaViewModel extends AndroidViewModel {
    CategoriaRepository repository;
    Context ctx;
    LiveData<List<String>> result;

    public CategoriaViewModel(@NonNull Application application) {
        super(application);
        this.repository = new CategoriaRepository();
        this.ctx = application.getApplicationContext();
    }

    public LiveData<List<String>> getCategories() {
        result = repository.getAllCategories();
        return result;
    }
}
