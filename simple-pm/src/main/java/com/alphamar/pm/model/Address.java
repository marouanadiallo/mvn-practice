package com.alphamar.pm.model;

public record Address(String street, String suite, String city, String zipcode, Geo geo) {
    public Address {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank");
        }
        if (suite == null || suite.isBlank()) {
            throw new IllegalArgumentException("Suite cannot be null or blank");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (zipcode == null || zipcode.isBlank()) {
            throw new IllegalArgumentException("Zipcode cannot be null or blank");
        }
    }
}
