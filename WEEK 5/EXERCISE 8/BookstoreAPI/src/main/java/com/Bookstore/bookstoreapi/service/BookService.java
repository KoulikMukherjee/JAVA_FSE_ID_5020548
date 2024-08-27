package com.Bookstore.bookstoreapi.service;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.exception.NotFoundException;
import com.Bookstore.bookstoreapi.mapper.BookMapper;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDTO(savedBook);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
        return bookMapper.bookToBookDTO(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book updatedBook = new Book();
        return bookRepository.findById(id)
                .map(existingBook -> {
                    Book book = bookMapper.bookDTOToBook(bookDTO);
                    book.setId(id);
                    book.setVersion(existingBook.getVersion());
                    return bookMapper.bookToBookDTO(updatedBook);
                })
                .orElseThrow(()-> new NotFoundException("Book not found"));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new NotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
