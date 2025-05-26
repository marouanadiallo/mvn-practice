package com.alphamar.simplemodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private String name;
    private String bs;
    private String catchPhrase;

    protected Company() {}

    public Company(String name, String bs, String catchPhrase) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (bs == null || bs.isBlank()) {
            throw new IllegalArgumentException("BS cannot be null or blank");
        }
        if (catchPhrase == null || catchPhrase.isBlank()) {
            throw new IllegalArgumentException("CatchPhrase cannot be null or blank");
        }

        this.name = name;
        this.bs = bs;
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public String getBs() {
        return bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }
}
