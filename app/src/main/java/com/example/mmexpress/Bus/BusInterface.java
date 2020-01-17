package com.example.mmexpress.Bus;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BusInterface {

    @POST("api/bus")
    Call<BusModel> getBusData(
            @Body int bus_gate_id
    );
}
