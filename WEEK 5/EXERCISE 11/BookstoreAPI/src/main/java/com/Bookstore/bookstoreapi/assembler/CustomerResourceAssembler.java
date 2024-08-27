package com.Bookstore.bookstoreapi.assembler;

import com.Bookstore.bookstoreapi.controller.CustomerController;
import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class CustomerResourceAssembler {

    public EntityModel<CustomerDTO> toModel(CustomerDTO customerDTO) {
        EntityModel<CustomerDTO> bookResource = EntityModel.of(customerDTO);

        Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(customerDTO.getId())).withSelfRel();
        Link allBooksLink = linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getAllCustomers()).withRel("all-books");

        bookResource.add(selfLink);
        bookResource.add(allBooksLink);

        return bookResource;
    }
}