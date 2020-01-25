package com.example.mmexpress.ui.gate;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmexpress.Adapter.GateAdapter;
import com.example.mmexpress.BusGate.GateInterface;
import com.example.mmexpress.BusGate.GateModel;
import com.example.mmexpress.BusGate.GateRetrofit;
import com.example.mmexpress.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GateFragment extends Fragment {
    RecyclerView gateview;
    List<GateModel.gateData> gatedata_list;
    GateAdapter gateAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gate, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gatedata_list =new ArrayList<>();
        gateview=(RecyclerView)view.findViewById(R.id.gate_list);
        gateview.setLayoutManager(new LinearLayoutManager(getContext()));
        setUpGateData();



    }

    private void setUpGateData() {
        GateInterface bus_gate= GateRetrofit.getGate().create(GateInterface.class);
        Call<GateModel> gateCall = bus_gate.getGateData();
        gateCall.enqueue(new Callback<GateModel>() {
            @Override
            public void onResponse(Call<GateModel> call, Response<GateModel> response) {
                GateModel gateModel=response.body();
                gatedata_list=gateModel.gate_datalist;
                gateAdapter=new GateAdapter(getContext(), gatedata_list);
                gateview.setAdapter(gateAdapter);
                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                Log.d("Bus Data ",""+response.code()+"*"+gatedata_list.size());
            }

            @Override
            public void onFailure(Call<GateModel> call, Throwable t) {
                Log.d("ErrorData",""+t.getMessage());
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}