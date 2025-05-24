package com.alphamar.pm.utils;

import com.alphamar.pm.model.Person;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonFormatterTest {

    @Test
    @DisplayName( "Test PersonFormatter")
    void testPersonFormatter() throws IOException {
        try (InputStream personStream = PersonFormatterTest.class.getClassLoader()
                .getResourceAsStream("persons.json");
            InputStream formatExpected = PersonFormatterTest.class.getClassLoader()
                    .getResourceAsStream("format-expected.dat")) {

            assertNotNull(personStream, "Person JSON file should not be null");
            assertNotNull(formatExpected, "Expected format file should not be null");

            List<Person> personList = JsonParser.parsePerson(new String(personStream.readAllBytes()));

            assertEquals(1, personList.size(), "Person list should contain at least one person");

            assertEquals(
                    IOUtils.toString(formatExpected, StandardCharsets.UTF_8).trim(),
                    PersonFormatter.format(personList.get(0)).trim(),
                    "Formatted person should match expected format"
            );
        }
    }
}
