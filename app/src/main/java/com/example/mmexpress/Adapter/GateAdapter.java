package com.example.mmexpress.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.BusGate.GateModel;
import com.example.mmexpress.R;
import com.example.mmexpress.ViewHolder.ViewHolder;
import com.example.mmexpress.ui.DetailView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.StringTokenizer;

public class GateAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<GateModel.gateData> gateList;
    int gate_id;

    public GateAdapter(Context context, List<GateModel.gateData> gateList) {
        this.context = context;
        this.gateList = gateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gate, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        GateModel.gateData mygate = gateList.get(i);
        holder.gatename.setText("" + mygate.getTitle());
        String date = mygate.getCreated_at();
        StringTokenizer st = new StringTokenizer(date, " ");
        String[] datetime = new String[2];
        int pos = 0;
        while (st.hasMoreTokens()) {
            datetime[pos] = st.nextToken();
            pos += 1;
        }

        holder.gatedate.setText("" + datetime[0]);

        holder.gatetime.setText("" + datetime[1]);
        holder.gateaddress.setText("" + mygate.getAddress());
        String img= "http://myfmovie.tentube.website/highway_bus/public/images/"+mygate.getCover();
        Picasso.get().load(img).into(holder.busgateimg);
        holder.gate_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gate_id=i;
                context.startActivity(new Intent(context, DetailView.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("Data", "" + gateList.size());
        return gateList.size();
    }
}
