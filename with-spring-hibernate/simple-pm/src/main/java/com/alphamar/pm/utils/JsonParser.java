package com.alphamar.pm.utils;

import com.alphamar.simplemodel.Person;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

public final class JsonParser {
    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public static List<Person> parsePerson(String json) {
        if (StringUtils.isBlank(json)) {
            logger.warn("Received empty or null JSON string");
            return List.of();
        }

        try {
            Gson gson = new Gson();
            TypeToken<Collection<Person>> persons = new TypeToken<>() {};
            return gson.fromJson(json, persons.getType());
        } catch (JsonSyntaxException e) {
            logger.error("Failed to parse JSON: {}", json, e);
            return List.of();
        }
    }
}
