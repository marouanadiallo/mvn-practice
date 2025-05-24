package com.alphamar.pm.model;

public record Geo(String lat, String lng) {
    public Geo {
        if (lat == null || lat.isBlank()) {
            throw new IllegalArgumentException("Latitude cannot be null or blank");
        }
        if (lng == null || lng.isBlank()) {
            throw new IllegalArgumentException("Longitude cannot be null or blank");
        }
    }
}
