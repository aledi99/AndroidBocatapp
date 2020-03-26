package com.salesianostriana.dam.retrofit.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    public AuthenticationInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", "Basic Ym9jYXRhcHAtcnVsZS01OnNlY3JldA==");

        Request request = builder.build();
        return chain.proceed(request);
    }
}
