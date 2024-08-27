package com.Bookstore.bookstoreapi.mapper;

import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.model.Customer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T17:18:56+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setPassword( customer.getPassword() );
        customerDTO.setVersion( customer.getVersion() );

        return customerDTO;
    }

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setPassword( customerDTO.getPassword() );
        customer.setVersion( customerDTO.getVersion() );

        return customer;
    }
}
