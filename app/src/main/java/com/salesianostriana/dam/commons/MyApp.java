package com.salesianostriana.dam.commons;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static MyApp instance;

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
}