package com.salesianostriana.dam;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import java.util.List;

import okhttp3.ResponseBody;


public class EstablecimientoViewModel extends AndroidViewModel {

    private EstablecimientoRepository establecimientoRepository;
    private MutableLiveData<List<Establecimiento>> listAllLocals;
    private MutableLiveData<String> idEstablecimientoSeleccionado;
    private MutableLiveData<ResponseBody> img;

    public EstablecimientoViewModel(@NonNull Application application) {
        super(application);
        establecimientoRepository = new EstablecimientoRepository();
        listAllLocals = new MutableLiveData<>();
        idEstablecimientoSeleccionado = new MutableLiveData<>();
        idEstablecimientoSeleccionado.setValue(null);
    }

    public MutableLiveData<List<Establecimiento>> listAlllocals(){
         listAllLocals = establecimientoRepository.getAllEstablecimientos();
         return listAllLocals;
    }



}
