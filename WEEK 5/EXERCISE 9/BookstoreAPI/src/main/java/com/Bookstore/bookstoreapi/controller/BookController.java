package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.Bookstore.bookstoreapi.assembler.BookResourceAssembler;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookResourceAssembler assembler;



    // Create a new book
    @PostMapping("/books/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<BookDTO>> createBook(@Valid @RequestBody BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = bookService.saveBook(bookDTO);
        return ResponseEntity.ok().header("Succesfully Registered", "Value").body(bookResource);
    }

    // Get a book by ID
    @GetMapping("books/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        EntityModel<BookDTO> bookResource = bookService.getBookById(id);
        return  ResponseEntity.ok().header("Succesfully Found", "Value").body(bookResource);
    }

    // Get all books
    @GetMapping("/books/All_Books")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CollectionModel<EntityModel<BookDTO>>> getAllBooks() {
        CollectionModel<EntityModel<BookDTO>> books = bookService.getAllBooks();
        if(books.getContent().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok().header("Succesfully Found", "Value").body(books);
    }

    // Update a book
    @PutMapping("books/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = bookService.saveBook(bookDTO);
        return ResponseEntity.ok().header("Succesfully Updated", "Value").body(bookResource);
    }

    // Delete a book
    @DeleteMapping("books/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().header("Succesfully Deleted","Value").build();
    }
}
