package com.example.mmexpress.BusGate;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GateModel {
    @SerializedName("status")
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @SerializedName("data")
    public List<gateData> gate_datalist=new ArrayList<>();

    public class gateData {
        @SerializedName("id")
        public int id;
        @SerializedName("title")
        public String title;
        @SerializedName("cover")
        public String cover;
        @SerializedName("latlong")
        public String latlong;
        @SerializedName("phone")
        public String phone;
        @SerializedName("description")
        public String description;
        @SerializedName("address")
        public String address;
        @SerializedName("created_by")
        public String created_by;
        @SerializedName("created_at")
        public String created_at;
        @SerializedName("updated_at")
        public String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getLatlong() {
            return latlong;
        }

        public void setLatlong(String latlong) {
            this.latlong = latlong;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}