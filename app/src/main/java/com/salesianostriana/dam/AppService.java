package com.salesianostriana.dam;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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


}
