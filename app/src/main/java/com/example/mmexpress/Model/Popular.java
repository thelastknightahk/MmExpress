package com.example.mmexpress.Model;

public class Popular {
    String place_start;
    String place_end;
    int place_image;

    public Popular(String place_start, String place_end, int place_image) {
        this.place_start = place_start;
        this.place_end = place_end;
        this.place_image = place_image;
    }

    public String getPlace_start() {
        return place_start;
    }

    public void setPlace_start(String place_start) {
        this.place_start = place_start;
    }

    public String getPlace_end() {
        return place_end;
    }

    public void setPlace_end(String place_end) {
        this.place_end = place_end;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }
}
