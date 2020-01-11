package com.example.mmexpress.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_pop,expname,exptype,routedate,routetime,routepirce;
    public ImageView img_pop,expimg;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_pop=(TextView)itemView.findViewById(R.id.txt_pop);
        img_pop=(ImageView)itemView.findViewById(R.id.img_pop);
        expimg=(ImageView)itemView.findViewById(R.id.route_expressimg);
        expname=(TextView)itemView.findViewById(R.id.exp_name);
        exptype=(TextView)itemView.findViewById(R.id.exp_type);
        routedate=(TextView)itemView.findViewById(R.id.route_date);
        routetime=(TextView)itemView.findViewById(R.id.route_time);
        routepirce=(TextView)itemView.findViewById(R.id.route_price);
    }
}
