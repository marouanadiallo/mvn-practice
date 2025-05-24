package com.alphamar.pm.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WebClientTest {

    @Test
    @DisplayName("Test WebClient")
    void testWebClient() {
        // Given
        String url = "https://jsonplaceholder.typicode.com/users";

        // When
        String response = WebClient.get(url).join();

        // Then
        assertNotEquals(StringUtils.EMPTY, response.trim(), "Response should not be empty");
    }
}
