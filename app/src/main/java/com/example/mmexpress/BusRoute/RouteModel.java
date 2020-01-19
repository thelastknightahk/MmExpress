package com.example.mmexpress.BusRoute;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RouteModel {
    @SerializedName("status")
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @SerializedName("data")
    public List<routeData> routeDataList=new ArrayList<>();

    public class routeData {
        @SerializedName("id")
        public int id;
        @SerializedName("place")
        public String place;
        @SerializedName("bus")
        public String bus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getBus() {
            return bus;
        }

        public void setBus(String bus) {
            this.bus = bus;
        }
    }
}