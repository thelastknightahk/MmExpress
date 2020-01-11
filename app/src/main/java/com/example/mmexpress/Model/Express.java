package com.example.mmexpress.Model;

public class Express {
    String busname;
    String classbus;
    String date;
    String time;
    String price;
    int bus;

    public Express(String busname, String classbus, String date, String time, String price, int bus) {
        this.busname = busname;
        this.classbus = classbus;
        this.date = date;
        this.time = time;
        this.price = price;
        this.bus = bus;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getClassbus() {
        return classbus;
    }

    public void setClassbus(String classbus) {
        this.classbus = classbus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }
}
