package com.salesianostriana.dam;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppService {

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<ResponseBody> login(
        @Field("client_id") String clientId,
        @Field("username") String username,
        @Field("password") String pswd,
        @Field("grant_type") String password,
        @Header("Authorization") String authorization

    );

    @GET("/api/local")
    Call<List<EstablecimientoReponse>> listaLocalesCercanos();

    @GET("/api/local/{id}")
    Call<EstablecimientoReponse> getOneLocalId();

    @FormUrlEncoded
    @POST("/client/register")
    Call<UserResponse> registerClient();

    @FormUrlEncoded
    @POST("/admin/register")
    Call<UserResponse> registerAdmin();

    @FormUrlEncoded
    @POST("/gerente/register")
    Call<UserResponse> registerGerente();



}
