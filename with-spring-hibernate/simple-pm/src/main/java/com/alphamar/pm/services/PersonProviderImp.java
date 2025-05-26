package com.alphamar.pm.services;

import com.alphamar.simplemodel.Person;
import com.alphamar.pm.utils.JsonParser;
import com.alphamar.pm.utils.WebClient;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class PersonProviderImp implements PersonProvider {
    private static final String PERSON_URL = "https://jsonplaceholder.typicode.com/users";
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PersonProviderImp.class);


    private List<Person> cachedPersonList = new ArrayList<>();

    @Override
    public void personList() {
        logger.info("Fetching person list from URL: {}", PERSON_URL);
        List<Person> personResponseList = WebClient.get(PERSON_URL).thenApply(JsonParser::parsePerson).join();
        this.cachedPersonList = Collections.unmodifiableList(personResponseList);
        logger.info("Fetched {} persons", personResponseList.size());
    }

    @Override
    public Optional<Person> findByName(String name) {
        if (cachedPersonList.isEmpty()) {
            this.personList();
        }
        return this.findByName(name, this.cachedPersonList);
    }

    @Override
    public Optional<Person> findbyEmail(String email) {
        if (cachedPersonList.isEmpty()) {
            this.personList();
        }
        return this.findByEmail(email, this.cachedPersonList);
    }

    public static PersonProvider newInstance() {
        return new PersonProviderImp();
    }

}
