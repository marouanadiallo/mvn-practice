package com.alphamar.pm;


import com.alphamar.pm.services.PersonService;
import com.alphamar.pm.services.PersonServiceImp;
import com.alphamar.pm.utils.PersonFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class PmMain {
    private static final Logger logger = LoggerFactory.getLogger(PmMain.class);
    private final String name;


    public PmMain(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        logger.info("Starting the application...");

        String searchName = "Glenna Reichert";

        try {
            searchName = Objects.isNull(args) || args.length == 0 ? searchName : args[0];
        } catch (Exception ignored) {}

        // Start the application with the provided name or default to "Glenna Reichert"
        new PmMain(searchName).start();

    }

    public void start() {
        PersonService personService = PersonServiceImp.newInstance();

        logger.info("Searching for person with name: {}", this.name);
        personService.findByName(this.name)
                .ifPresentOrElse(
                        person -> System.out.printf("%s%n", PersonFormatter.format(person)),
                        () -> logger.warn("Person with name '{}' not found", this.name)
                );
    }

}
