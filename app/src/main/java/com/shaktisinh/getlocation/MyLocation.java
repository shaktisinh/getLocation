package com.shaktisinh.getlocation;

/**
 * Created by SPECBEE on 5/20/2017.
 */

public class MyLocation {
    private double latitude;
    private double longitude;
    private String timeStamp;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
