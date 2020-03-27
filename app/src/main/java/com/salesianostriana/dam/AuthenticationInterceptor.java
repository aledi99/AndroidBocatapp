package com.salesianostriana.dam;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String access_token;

    public AuthenticationInterceptor(String access_token) {
        this.access_token= access_token;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {

        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", access_token);

        Request request = builder.build();

        return chain.proceed(request);
    }
}