package com.alphamar.simplemodel;

import jakarta.persistence.Embeddable;

@Embeddable
public class Geo {

    private String lat;
    private String lng;

    protected Geo() {}
    public Geo(String lat, String lng) {
        if (lat == null || lat.isBlank()) {
            throw new IllegalArgumentException("Latitude cannot be null or blank");
        }
        if (lng == null || lng.isBlank()) {
            throw new IllegalArgumentException("Longitude cannot be null or blank");
        }
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
