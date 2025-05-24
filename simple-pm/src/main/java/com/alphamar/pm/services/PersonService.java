package com.alphamar.pm.services;

import com.alphamar.pm.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void personList();
    Optional<Person> findByName(String name);
    Optional<Person> findbyEmail(String email);

    default Optional<Person> findByName(String name, List<Person> persons) {
        return persons.stream()
                .filter(person -> person.name().equalsIgnoreCase(name))
                .findFirst();
    }

    default Optional<Person> findByEmail(String email, List<Person> persons) {
        return persons.stream()
                .filter(person -> person.email().equalsIgnoreCase(email))
                .findFirst();
    }
}
