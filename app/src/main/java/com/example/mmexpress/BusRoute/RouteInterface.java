package com.example.mmexpress.BusRoute;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RouteInterface {
    @Multipart
    @POST("api/bus/route")
    Call<RouteModel> getRouteData(
            @Part("bus_id") int bus_id
    );
}
