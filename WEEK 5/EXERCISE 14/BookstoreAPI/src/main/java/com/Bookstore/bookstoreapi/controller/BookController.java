package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.metrics.BookCustomMetrics;
import com.Bookstore.bookstoreapi.service.BookService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookCustomMetrics metrics;

    public BookController(BookService bookService, BookCustomMetrics metrics) {
        this.bookService = bookService;
        this.metrics = metrics;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<BookDTO>> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        EntityModel<BookDTO> bookResource = EntityModel.of(createdBook);
        metrics.incrementBookCreated();
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResource);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);
        return ResponseEntity.ok(bookResource);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<EntityModel<BookDTO>> bookResources = bookService.getAllBooks().stream()
                .map(EntityModel::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookResources);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        EntityModel<BookDTO> bookResource = EntityModel.of(updatedBook);
        return ResponseEntity.ok(bookResource);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        metrics.incrementBookDeleted();
        return ResponseEntity.noContent().build();
    }


}
