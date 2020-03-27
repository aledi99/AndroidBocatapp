package com.salesianostriana.dam;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import java.util.List;



public class EstablecimientoViewModel extends AndroidViewModel {

    private EstablecimientoRepository establecimientoRepository;
    private MutableLiveData<List<EstablecimientoResponse>> listAllLocals;
    MutableLiveData<Integer> idEstablecimientoSeleccionado;


    public EstablecimientoViewModel(@NonNull Application application) {
        super(application);
        establecimientoRepository = new EstablecimientoRepository();
        listAllLocals = new MutableLiveData<>();
        this.idEstablecimientoSeleccionado = new MutableLiveData<>();
        this.idEstablecimientoSeleccionado.setValue(null);
            }

    public MutableLiveData<List<EstablecimientoResponse>> listAlllocals(){
        listAllLocals = establecimientoRepository.getAllEstablecimientos();
         return listAllLocals;
    }

    public void setIdEstablecimientoSeleccionado(Integer idEstablecimientoSeleccionado) {
        this.idEstablecimientoSeleccionado.setValue(idEstablecimientoSeleccionado);
    }

    public MutableLiveData<Integer> getIdEstablecimientoSeleccionado() {
        return idEstablecimientoSeleccionado;
    }



}
