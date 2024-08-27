package com.Bookstore.bookstoreapi.controller.controller;

import com.Bookstore.bookstoreapi.controller.BookController;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBookById() throws Exception {
        Book mockBook = new Book(1L, "Book Title", "Author Name", 29.99, "1234567890123");
        when(bookService.getBookById(anyLong())).thenAnswer(invocation -> mockBook);
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk());
    }
}
