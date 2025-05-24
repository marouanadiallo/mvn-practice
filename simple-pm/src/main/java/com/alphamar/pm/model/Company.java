package com.alphamar.pm.model;

public record Company(String name, String catchPhrase, String bs) {
    public Company {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (catchPhrase == null || catchPhrase.isBlank()) {
            throw new IllegalArgumentException("CatchPhrase cannot be null or blank");
        }
        if (bs == null || bs.isBlank()) {
            throw new IllegalArgumentException("BS cannot be null or blank");
        }
    }
}
