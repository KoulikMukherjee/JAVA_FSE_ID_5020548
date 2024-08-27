package com.Bookstore.bookstoreapi.service;

import com.Bookstore.bookstoreapi.assembler.BookResourceAssembler;
import com.Bookstore.bookstoreapi.controller.BookController;
import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.exception.NotFoundException;
import com.Bookstore.bookstoreapi.mapper.BookMapper;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookResourceAssembler assembler;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public EntityModel<BookDTO> saveBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        EntityModel<BookDTO> bookResource = assembler.toModel(bookMapper.bookToBookDTO(savedBook));
        return bookResource;
    }

    public EntityModel<BookDTO> getBookById (Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
        EntityModel<BookDTO> bookResource = assembler.toModel(bookMapper.bookToBookDTO(book));
        return bookResource;
    }

    public CollectionModel<EntityModel<BookDTO>> getAllBooks() {
        List<EntityModel<BookDTO>> books = bookRepository.findAll().stream()
                .map(bookMapper::bookToBookDTO)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        CollectionModel<EntityModel<BookDTO>> booksResource = CollectionModel.of(
                books,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withSelfRel());
        return booksResource;
    }

    public EntityModel<BookDTO> updateBook(Long id, BookDTO bookDTO) {
        Book updatedBook = new Book();
        return bookRepository.findById(id)
                .map(existingBook -> {
                    Book book = bookMapper.bookDTOToBook(bookDTO);
                    book.setId(id);
                    book.setVersion(existingBook.getVersion());
                    return bookMapper.bookToBookDTO(updatedBook);
                }).map(assembler::toModel)
                .orElseThrow(()-> new NotFoundException("Book not found"));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new NotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
