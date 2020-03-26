package com.salesianostriana.dam;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstablecimientoRepository {

    LiveData<List<Establecimiento>> allEstablecimientos;
    AppService appService;

    public EstablecimientoRepository() {
        allEstablecimientos = getAllEstablecimientos();
    }

    public MutableLiveData<List<Establecimiento>> getAllEstablecimientos() {
        final MutableLiveData<List<Establecimiento>> dataTicket = new MutableLiveData<>();

        Call<List<Establecimiento>> call = appService.listaLocalesCercanos();
        call.enqueue(new Callback<List<Establecimiento>>() {
            @Override
            public void onResponse(Call<List<Establecimiento>> call, Response<List<Establecimiento>> response) {
                if(response.isSuccessful()){
                    dataTicket.setValue(response.body());
                }else{
                    Toast.makeText(MyApp.getContext(), "No se ha podido obtener resultados del api", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Establecimiento>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });

        return dataTicket;
    }




    /*public MutableLiveData<User> changeUser(String id, String name){
        final MutableLiveData<User> data = new MutableLiveData<>();
        Call<User> call = service.updateNombre(id,name);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                    Log.i("put","Usuario actualizado correctamente");
                }else {
                    Log.e("put","Actualización errónea");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("putUser","Error modificando el usuario");
            }
        });
        userChange = data;
        return data;
    }

    public MutableLiveData<User> getUserLogged(){
        final MutableLiveData<User> data = new MutableLiveData<>();
        Call<User> call = appService.getLoggedUser();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return data;
    }*/
}
