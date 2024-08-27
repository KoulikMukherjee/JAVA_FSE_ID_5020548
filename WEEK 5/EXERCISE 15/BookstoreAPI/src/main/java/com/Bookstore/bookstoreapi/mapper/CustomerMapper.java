package com.Bookstore.bookstoreapi.mapper;

import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    CustomerDTO toDTO(Customer customer);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    Customer toEntity(CustomerDTO customerDTO);
}
