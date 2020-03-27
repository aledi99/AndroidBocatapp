package com.salesianostriana.dam;

import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.salesianostriana.dam.commons.MyApp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstablecimientoRepository {

    LiveData<List<EstablecimientoResponse>> allEstablecimientos;
    AppService appService;

    public EstablecimientoRepository() {
        appService = ServiceGenerator.createServiceEstablecimiento(AppService.class);
        allEstablecimientos = getAllEstablecimientos();

    }

    public MutableLiveData<List<EstablecimientoResponse>> getAllEstablecimientos() {
        final MutableLiveData<List<EstablecimientoResponse>> dataLocales = new MutableLiveData<>();

        Call<List<EstablecimientoResponse>> call = appService.listaLocalesCercanos();
        call.enqueue(new Callback<List<EstablecimientoResponse>>() {
            @Override
            public void onResponse(Call<List<EstablecimientoResponse>> call, Response<List<EstablecimientoResponse>> response) {
                if(response.isSuccessful()){
                    dataLocales.setValue(response.body());
                }else{
                    //Toast.makeText(MyApp.getContext(), "No se ha podido obtener resultados del api", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<EstablecimientoResponse>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });

        return dataLocales;
    }




    public MutableLiveData<EstablecimientoResponse> getEstablecimiento(int idEstablecimiento) {
        final MutableLiveData<EstablecimientoResponse> data = new MutableLiveData<>();

        Call<EstablecimientoResponse> call = appService.getOneLocalId(String.valueOf(idEstablecimiento));
        call.enqueue(new Callback<EstablecimientoResponse>() {
            @Override
            public void onResponse(Call<EstablecimientoResponse> call, Response<EstablecimientoResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<EstablecimientoResponse> call, Throwable t) {

            }
        });

        return data;
    }
}
