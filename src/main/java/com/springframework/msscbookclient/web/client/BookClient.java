package com.springframework.msscbookclient.web.client;

import com.springframework.msscbookclient.web.model.BookDto;
import com.springframework.msscbookclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/*
@ConfigurationProperties
"sfg.book" acts as prefix to access variables from application.properties file
 ignoreUnknownFields=false so if it's not set, it should fail
*/

@ConfigurationProperties(prefix = "sfg.book", ignoreUnknownFields = false)
@Component
public class BookClient {
    private final String BOOK_PATH_V1 = "/api/v1/book/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BookClient(RestTemplateBuilder restTemplateBuilder) {
        // uses an instance of RestTemplateBuilder to get the RestTemplate
        this.restTemplate = restTemplateBuilder.build();
    }

    public BookDto getBookById(UUID id) {
        // 2nd argument is BookDto.class as we are expecting that
        return restTemplate.getForObject(apiHost + BOOK_PATH_V1 + id.toString(), BookDto.class);
    }

    public URI saveNewBook(BookDto bookDto) {
        // POST action
        return restTemplate.postForLocation(apiHost + BOOK_PATH_V1, bookDto);
    }

    public void updateBook(UUID uuid, BookDto bookDto) {
        restTemplate.put(apiHost + BOOK_PATH_V1 + uuid.toString(), bookDto);
    }

    public void deleteBook(UUID uuid) {
        restTemplate.delete(apiHost + BOOK_PATH_V1 + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID id) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + id.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + uuid.toString());
    }
}
