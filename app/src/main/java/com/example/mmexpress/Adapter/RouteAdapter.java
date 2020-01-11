package com.example.mmexpress.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Model.Express;
import com.example.mmexpress.R;
import com.example.mmexpress.ViewHolder.ViewHolder;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Express> data;
    public RouteAdapter(Context context,List<Express> data){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_express, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Express model=data.get(i);
        holder.expimg.setImageResource(model.getBus());
        holder.expname.setText("Bus Name :"+model.getBusname());
        holder.exptype.setText(""+model.getClassbus());
        holder.routedate.setText(""+model.getDate());
        holder.routetime.setText(""+model.getTime());
        holder.routepirce.setText(""+model.getPrice()+" MMK");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

