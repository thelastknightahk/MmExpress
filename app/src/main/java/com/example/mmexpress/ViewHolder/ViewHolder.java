package com.example.mmexpress.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_pop,expname,exptype,routedate,routetime,routepirce,
            gatename,gatedate,gatetime,gateaddress;
    public ImageView img_pop,expimg,busgateimg;
    public CardView gate_card;
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
        //for gate
        gatename=(TextView)itemView.findViewById(R.id.gate_name);
        gatedate=(TextView)itemView.findViewById(R.id.gate_date);
        gatetime=(TextView)itemView.findViewById(R.id.gate_time);
        gateaddress=(TextView)itemView.findViewById(R.id.gate_address);
        busgateimg=(ImageView)itemView.findViewById(R.id.gatebus_img);
        gate_card=(CardView)itemView.findViewById(R.id.gate_card);
    }
}
