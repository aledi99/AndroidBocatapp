package com.salesianostriana.dam;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


public class DetalleEstablecimientoViewModel extends AndroidViewModel {

    MutableLiveData<EstablecimientoResponse> unEstablecimiento;
    EstablecimientoRepository establecimientoRepository;

    public DetalleEstablecimientoViewModel(@NonNull Application application) {
        super(application);
        establecimientoRepository = new EstablecimientoRepository();
    }

    public MutableLiveData<EstablecimientoResponse> getUnEstablecimiento(int idEstablecimiento) {
        unEstablecimiento = establecimientoRepository.getEstablecimiento(idEstablecimiento);
        return unEstablecimiento;
    }
}
