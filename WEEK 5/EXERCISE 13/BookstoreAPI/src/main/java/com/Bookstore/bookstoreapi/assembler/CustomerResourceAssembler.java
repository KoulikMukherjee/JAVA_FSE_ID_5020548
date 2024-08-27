package com.Bookstore.bookstoreapi.assembler;

import com.Bookstore.bookstoreapi.controller.CustomerController;
import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler {

    public EntityModel<CustomerDTO> toModel(CustomerDTO customerDTO) {
        // Create the base link
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getCustomerById(customerDTO.getId())).withSelfRel();

        // Create the resource model with links
        return EntityModel.of(customerDTO, selfLink);
    }
}
