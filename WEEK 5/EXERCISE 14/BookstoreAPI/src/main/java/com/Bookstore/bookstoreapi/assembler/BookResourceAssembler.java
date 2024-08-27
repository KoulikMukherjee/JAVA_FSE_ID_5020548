package com.Bookstore.bookstoreapi.assembler;

import com.Bookstore.bookstoreapi.controller.BookController;
import com.Bookstore.bookstoreapi.dto.BookDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler {

    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        // Create the base link
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                .getBookById(bookDTO.getId())).withSelfRel();

        // Create the resource model with links
        return EntityModel.of(bookDTO, selfLink);
    }
}
