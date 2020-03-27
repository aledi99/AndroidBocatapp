package com.salesianostriana.dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.salesianostriana.dam.commons.Constants;
import com.salesianostriana.dam.commons.MyApp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleEstablecimientoActivity extends AppCompatActivity {

    int idEstablecimiento;
    DetalleEstablecimientoViewModel detalleEstablecimientoViewModel;
    TextView nombre, ubicacion, categoria, descripcion;
    ImageView fotoEstablecimiento;
    AppService appService = ServiceGenerator.createServiceEstablecimiento(AppService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_establecimiento);

        nombre = findViewById(R.id.nombre);
        ubicacion = findViewById(R.id.ubicacion);
        categoria = findViewById(R.id.categoria);
        descripcion = findViewById(R.id.textView2);
        fotoEstablecimiento = findViewById(R.id.imageViewImagen);

        Bundle extras = getIntent().getExtras();
        idEstablecimiento = extras.getInt(Constants.ID_ESTABLECIMIENTO);

        Toast.makeText(this, "Id: " + idEstablecimiento, Toast.LENGTH_SHORT).show();

        detalleEstablecimientoViewModel = new ViewModelProvider(this).get(DetalleEstablecimientoViewModel.class);


        detalleEstablecimientoViewModel.getUnEstablecimiento(idEstablecimiento).observe(this, new Observer<EstablecimientoResponse>() {
            @Override
            public void onChanged(EstablecimientoResponse establecimientoDetalle) {
                if (establecimientoDetalle != null) {

                    nombre.setText(establecimientoDetalle.getNombre());
                    if(establecimientoDetalle.getDescripcion() != null) {
                        descripcion.setText(establecimientoDetalle.getDescripcion());
                    }
                    ubicacion.setText(String.valueOf(establecimientoDetalle.getLocalizacion().getLatitud())+ String.valueOf(establecimientoDetalle.getLocalizacion().getLongitud()));
                    
                    if(establecimientoDetalle.getCategoria() != null) {
                        categoria.setText(establecimientoDetalle.getCategoria().getNombre());
                    }

                    if (establecimientoDetalle.getImagen() != null) {
                        Call<ResponseBody> call = appService.downImage(establecimientoDetalle.getImagen().getNombreFichero());
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()) {
                                    if (response.body() != null) {
                                        Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());
                                        Glide
                                                .with(MyApp.getContext())
                                                .load(bmp)
                                                .into(fotoEstablecimiento);
                                    } else {
                                        Toast.makeText(MyApp.getContext(), "No funciona loko", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(MyApp.getContext(), "No se pudo cargar la imagen", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }

                } else {
                    Toast.makeText(DetalleEstablecimientoActivity.this, "NO FUNCIONA DETALLES", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

}
