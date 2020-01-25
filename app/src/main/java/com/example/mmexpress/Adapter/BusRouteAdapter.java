package com.example.mmexpress.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Bus.BusModel;

import com.example.mmexpress.BusRoute.RouteInterface;
import com.example.mmexpress.BusRoute.RouteModel;

import com.example.mmexpress.BusRoute.RouteRetrofit;
import com.example.mmexpress.R;
import com.example.mmexpress.ViewHolder.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusRouteAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<BusModel.busData> busData;
    List<RouteModel.routeData> routeData;

    public BusRouteAdapter(Context context, List<BusModel.busData> busData) {
        this.context = context;
        this.busData = busData;
        this.routeData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        final BusModel.busData bus = busData.get(i);
        holder.price_bus.setText("" + bus.getPrice());
        RouteInterface busroute = RouteRetrofit.getRoute().create(RouteInterface.class);
        Call<RouteModel> routeModelCall = busroute.getRouteData(bus.getId());
        final int index = bus.getId();
        routeModelCall.enqueue(new Callback<RouteModel>() {
            @Override
            public void onResponse(Call<RouteModel> call, Response<RouteModel> response) {
                RouteModel routeModel = response.body();
                routeData = routeModel.routeDataList;
                String routes_data = "";

                for (int index = 0; index < routeData.size(); index++) {

                    routes_data += routeData.get(index).getPlace() + "   ";
                }

                holder.route_bus.setText("" + routes_data);


            }

            @Override
            public void onFailure(Call<RouteModel> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("BusData size", "" + busData.size());
        return busData.size();
    }
}
