package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository bookRepository = (BookRepository) context.getBean("BookRepository");
        BookService bookService = (BookService) context.getBean("BookService");
        bookService.setBookRepository(bookRepository);
    }
}