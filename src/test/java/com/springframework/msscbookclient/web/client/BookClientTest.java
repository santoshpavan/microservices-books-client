package com.springframework.msscbookclient.web.client;

import com.springframework.msscbookclient.web.model.BookDto;
import com.springframework.msscbookclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookClientTest {

    @Autowired
    BookClient client;

    // book tests
    @Test
    void testGetBookById() {
        BookDto bookDto = client.getBookById(UUID.randomUUID());
        assertNotNull(bookDto);
    }

    @Test
    void testSaveNewBook() {
        // given book
        BookDto bookDto = BookDto.builder().bookName("New Book").build();

        URI uri = client.saveNewBook(bookDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBook() {
        BookDto bookDto = BookDto.builder().bookName("New Book").build();
        client.updateBook(UUID.randomUUID(), bookDto);
    }

    @Test
    void testDeleteBook() {
        client.deleteBook(UUID.randomUUID());
    }

    // customer tests
    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull((customerDto));
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().customerName("New Customer").build();

        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().customerName("New Customer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}