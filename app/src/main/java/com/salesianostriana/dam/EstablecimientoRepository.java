package com.salesianostriana.dam;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstablecimientoRepository {

    LiveData<List<EstablecimientoReponse>> allEstablecimientos;
    AppService appService;

    public EstablecimientoRepository() {
        allEstablecimientos = getAllTickets();
    }

    public LiveData<List<EstablecimientoReponse>> getAllTickets() {
        final MutableLiveData<List<EstablecimientoReponse>> dataTicket = new MutableLiveData<>();

        Call<List<EstablecimientoReponse>> call = appService.listaLocalesCercanos();
        call.enqueue(new Callback<List<EstablecimientoReponse>>() {
            @Override
            public void onResponse(Call<List<EstablecimientoReponse>> call, Response<List<EstablecimientoReponse>> response) {
                if(response.isSuccessful()){
                    dataTicket.setValue(response.body());
                }else{
                    Toast.makeText(MyApp.getContext(), "No se ha podido obtener resultados del api", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<EstablecimientoReponse>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });

        return dataTicket;
    }
}
