package com.alphamar.pm.utils;

import com.alphamar.simplemodel.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    @DisplayName( "Test JsonParser")
    void testJsonParser() throws IOException {
        try (InputStream inputStream = JsonParserTest.class.getClassLoader()
                .getResourceAsStream("persons.json")) {

            assertNotNull(inputStream);
            List<Person> personList = JsonParser.parsePerson(new String(inputStream.readAllBytes()));

            assertEquals(1, personList.size(), "Person list should contain one person");
        }
    }
}
