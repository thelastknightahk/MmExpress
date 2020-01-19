package com.example.mmexpress.BusRoute;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RouteRetrofit {
    public static final String BASE_URL = "http://myfmovie.tentube.website/highway_bus/public/";
    private static Retrofit retrofit = null;


    public static Retrofit getRoute() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
