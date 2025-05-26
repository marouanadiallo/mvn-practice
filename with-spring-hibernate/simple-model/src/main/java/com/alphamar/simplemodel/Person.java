package com.alphamar.simplemodel;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
@NamedQueries({
        @NamedQuery(name = "Person.byName",
                query = "SELECT p FROM Person p WHERE p.name = :name"),
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private String name;
    private String email;

    @Embedded
    private Address address;

    private String phone;
    private String website;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    protected Person() {
        this.id = null;
    }

    public Person(Long id, String name, String email, Address address, String phone, String website, Company company) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or blank");
        }
        if (website == null || website.isBlank()) {
            throw new IllegalArgumentException("Website cannot be null or blank");
        }
        if (company == null) {
            throw new IllegalArgumentException("Company cannot be null");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;

        return email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}