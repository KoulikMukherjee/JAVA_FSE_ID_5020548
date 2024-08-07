package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public BookService() {
        System.out.println("Constructor Called:\tInitialized Book Service");
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("setBookRepository() Called:\tAdded Book Repository");
    }
}
