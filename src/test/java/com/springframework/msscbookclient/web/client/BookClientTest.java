package com.springframework.msscbookclient.web.client;

import com.springframework.msscbookclient.web.model.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookClientTest {

    @Autowired
    BookClient client;

    @Test
    void getBookById() {
        BookDto dto = client.getBookById(UUID.randomUUID());
        assertNotNull(dto);
    }
}