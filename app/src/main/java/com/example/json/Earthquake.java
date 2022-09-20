package com.example.json;


import java.net.URL;

public class Earthquake {
private  final Double magnitude;
private final long time;
private final String location;
private  String url;


    public Earthquake(Double magnitude, long time, String location, String url) {
        this.magnitude = magnitude;
        this.time = time;
        this.location = location;
        this.url = url;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public long getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl(){
        return  url;
    }


}
