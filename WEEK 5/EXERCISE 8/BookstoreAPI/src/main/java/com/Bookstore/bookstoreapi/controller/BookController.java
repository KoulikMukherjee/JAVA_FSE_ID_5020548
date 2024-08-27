package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.exception.NotFoundException;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Create a new book
    @PostMapping("/books/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO book = bookService.saveBook(bookDTO);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(book);
    }

    // Get a book by ID
    @GetMapping("books/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    // Get all books
    @GetMapping("/books/All_Books")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        if(books.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(books);
    }

    // Update a book
    @PutMapping("books/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete a book
    @DeleteMapping("books/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
