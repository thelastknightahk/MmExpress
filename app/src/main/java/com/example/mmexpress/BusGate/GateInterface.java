package com.example.mmexpress.BusGate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GateInterface {

    @POST("api/bus/gate")
    Call<GateModel> getGateData();
}
