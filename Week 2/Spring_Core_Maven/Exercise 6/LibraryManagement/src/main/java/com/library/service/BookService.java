package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("Constructor called:\tInitialized Book Service");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("setBookRepository() called:\tAdded Book Repository");
    }
}
