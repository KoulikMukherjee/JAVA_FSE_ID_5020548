package com.Bookstore.bookstoreapi.repository;

import com.Bookstore.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
