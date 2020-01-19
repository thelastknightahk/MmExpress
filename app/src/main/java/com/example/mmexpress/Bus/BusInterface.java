package com.example.mmexpress.Bus;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface BusInterface {
    @Multipart
    @POST("api/bus")
    Call<BusModel> getBusData(
            @Part("bus_gate_id") int bus_gate_id
    );
}
