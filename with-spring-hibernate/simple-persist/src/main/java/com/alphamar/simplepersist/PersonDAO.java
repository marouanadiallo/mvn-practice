package com.alphamar.simplepersist;

import com.alphamar.simplemodel.Person;

import java.util.List;

public interface PersonDAO {
    /**
     * Saves a person to the database.
     *
     * @param person the person to save
     * @return the saved person
     */
    Person save(Person person);

    /**
     * Finds a person by their name.
     *
     * @param name the name of the person to find
     * @return the found person, or null if no person with that name exists
     */
    Person findByName(String name);

    /**
     * Finds all persons in the database.
     *
     * @return a list of all persons
     */
    List<Person> findAll();
}
