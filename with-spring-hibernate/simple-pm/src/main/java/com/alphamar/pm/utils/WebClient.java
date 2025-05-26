package com.alphamar.pm.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public final class WebClient {

    private static final Logger logger = LoggerFactory.getLogger(WebClient.class);

    public static CompletableFuture<String> get(String url) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> respond(url, response));
    }

    private static String respond(String url, HttpResponse<String> response) {
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            logger.error("Failed to fetch data from URL: {}. Status code: {}", url, response.statusCode());
            return StringUtils.EMPTY;
        }
    }
}
