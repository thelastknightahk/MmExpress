package com.example.mmexpress.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Adapter.BusRouteAdapter;
import com.example.mmexpress.Bus.BusInterface;
import com.example.mmexpress.Bus.BusModel;
import com.example.mmexpress.Bus.BusRetrofit;
import com.example.mmexpress.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mmexpress.Adapter.GateAdapter.gate_id;

public class DetailView extends AppCompatActivity {
    RecyclerView bus_list;
    List<BusModel.busData> busData;
    BusRouteAdapter busRouteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        bus_list=(RecyclerView)findViewById(R.id.bus_list);
        busData=new ArrayList<>();
        setBusData();
        bus_list.setLayoutManager(new LinearLayoutManager(DetailView.this));

    }
    private void setBusData(){
        BusInterface mybus= BusRetrofit.getBus().create(BusInterface.class);
        Call<BusModel> busModelCall=mybus.getBusData(gate_id);
        busModelCall.enqueue(new Callback<BusModel>() {
            @Override
            public void onResponse(Call<BusModel> call, Response<BusModel> response) {
                BusModel busModel=response.body();

                    busData=busModel.busdataList;
                    busRouteAdapter=new BusRouteAdapter(DetailView.this,busData);
                    bus_list.setAdapter(busRouteAdapter);
                Log.d("BusData size1",""+busData.size());

            }

            @Override
            public void onFailure(Call<BusModel> call, Throwable t) {

            }
        });
    }



}
