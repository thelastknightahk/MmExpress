package com.example.mmexpress.Bus;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BusModel {
    @SerializedName("status")
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @SerializedName("data")
    public List<busData> busdataList=new ArrayList<>();

    public class busData {
        @SerializedName("id")
        public int id;
        @SerializedName("no")
        public String no;
        @SerializedName("price")
        public String price;
        @SerializedName("bus_gate_id")
        public String bus_gate_id;
        @SerializedName("created_at")
        public String created_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBus_gate_id() {
            return bus_gate_id;
        }

        public void setBus_gate_id(String bus_gate_id) {
            this.bus_gate_id = bus_gate_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}