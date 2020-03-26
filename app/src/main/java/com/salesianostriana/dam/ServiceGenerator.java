package com.salesianostriana.dam;

import android.text.TextUtils;


import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static final String BASE_URL = "http://10.0.2.2:9000";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(60,TimeUnit.SECONDS);


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(
            Class<S> serviceClass, String email, String password) {
        if (!TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(password)) {
            String authToken = Credentials.basic(email, password);
            return createService(serviceClass, authToken);
        }

        return createService(serviceClass, null);
    }



    public static <S> S createService(
            Class<S> serviceClass, final String authToken) {
        /*
        if (!TextUtils.isEmpty(authToken)) {
            BasicAuthenticationInterceptor interceptor =
                    new BasicAuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                httpClient.addInterceptor(logging);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
*/
        return retrofit.create(serviceClass);
    }

}