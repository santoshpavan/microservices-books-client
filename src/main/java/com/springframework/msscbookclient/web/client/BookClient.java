package com.springframework.msscbookclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
@ConfigurationProperties
"sfg.book" acts as prefix to access variables from application.properties file
 ignoreUnknownFields=false so if it's not set, it should fail
*/

@Component
@ConfigurationProperties(value = "sfg.book", ignoreUnknownFields = false)
public class BookClient {
    private final String BOOK_PATH_V1 = "/api/v1/book";
    private String apiHost;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
