package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.metrics.BookCustomMetrics;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "API for managing books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookCustomMetrics metrics;

    @PostMapping
    @Operation(summary = "Create a new book", description = "Create a new book in the system")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        metrics.incrementBookCreated();
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieve a book by its ID")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a book", description = "Update an existing book by its ID")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book", description = "Delete a book by its ID")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        metrics.incrementBookDeleted();
        return ResponseEntity.noContent().build();
    }
}
