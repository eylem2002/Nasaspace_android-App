package com.example.google_map;
public class MarkerData {
    private double latitude;
    private double longitude;
    private String title;
    private String snippet;
    private int iconResID;

    public MarkerData(double latitude, double longitude, String title, String snippet, int iconResID) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.snippet = snippet;
        this.iconResID = iconResID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public int getIconResID() {
        return iconResID;
    }
}
