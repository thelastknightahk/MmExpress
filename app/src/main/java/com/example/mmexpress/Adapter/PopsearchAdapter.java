package com.example.mmexpress.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Model.Popular;
import com.example.mmexpress.R;
import com.example.mmexpress.ViewHolder.ViewHolder;

import java.util.List;

public class PopsearchAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Popular> data;
    public PopsearchAdapter(Context context,List<Popular> data){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Popular model=data.get(i);
        holder.img_pop.setImageResource(model.getPlace_image());
        holder.txt_pop.setText(model.getPlace_start()+"<=>"+model.getPlace_end());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
