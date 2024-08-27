package com.Bookstore.bookstoreapi.mapper;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.model.Book;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T17:18:56+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setVersion( book.getVersion() );

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        if ( bookDTO.getId() != null ) {
            book.setId( bookDTO.getId() );
        }
        book.setTitle( bookDTO.getTitle() );
        book.setAuthor( bookDTO.getAuthor() );
        if ( bookDTO.getPrice() != null ) {
            book.setPrice( bookDTO.getPrice() );
        }
        book.setIsbn( bookDTO.getIsbn() );
        book.setVersion( bookDTO.getVersion() );

        return book;
    }
}
