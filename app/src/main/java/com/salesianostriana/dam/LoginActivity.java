package com.salesianostriana.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.salesianostriana.dam.commons.SharedPreferencesManager;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://bocatapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create());
    public static Retrofit retrofit = builder.build();

    EditText email,password;
    Button btnLogin;
    String clientId ="bocatapp-rule-5",grant_type = "password", authorization = "Basic Ym9jYXRhcHAtcnVsZS01OnNlY3JldA==";
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo = findViewById(R.id.imageView8);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button2);

        Glide.with(LoginActivity.this).load(R.drawable.icono).into(logo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeLoginForm(
                        clientId,
                        email.getText().toString(),
                        password.getText().toString(),
                        grant_type,
                        authorization

                );
            }


        });

    }

    private void executeLoginForm(String clientId, String username, String pswd, String password,String authorization){
        AppService appService = retrofit.create(AppService.class);

        Call<ResponseBody> call = appService.login(
                clientId,
                username,
                pswd,
                password,
                authorization
        );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "logeado correctamente", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    //startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Email y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
