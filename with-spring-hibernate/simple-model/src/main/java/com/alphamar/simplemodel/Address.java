package com.alphamar.simplemodel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;

    protected Address() {}

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
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
        if (geo == null) {
            throw new IllegalArgumentException("Geo cannot be null");
        }

        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }
}
