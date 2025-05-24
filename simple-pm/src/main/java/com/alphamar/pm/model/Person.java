package com.alphamar.pm.model;

public record Person(Long id, String name, String email, Address address, String phone, String website, Company company) {
    public Person {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or blank");
        }
        if (website == null || website.isBlank()) {
            throw new IllegalArgumentException("Website cannot be null or blank");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (company == null) {
            throw new IllegalArgumentException("Company cannot be null");
        }
    }
}