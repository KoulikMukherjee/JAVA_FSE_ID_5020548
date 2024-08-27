package com.Bookstore.bookstoreapi.service;

import com.Bookstore.bookstoreapi.assembler.BookResourceAssembler;
import com.Bookstore.bookstoreapi.assembler.CustomerResourceAssembler;
import com.Bookstore.bookstoreapi.controller.BookController;
import com.Bookstore.bookstoreapi.controller.CustomerController;
import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.exception.NotFoundException;
import com.Bookstore.bookstoreapi.mapper.CustomerMapper;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.model.Customer;
import com.Bookstore.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerResourceAssembler assembler;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public EntityModel<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        EntityModel<CustomerDTO> customerResource = assembler.toModel(customerMapper.customerToCustomerDTO(savedCustomer));
        return customerResource;
    }

    public EntityModel<CustomerDTO> getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        EntityModel<CustomerDTO> customerResource = assembler.toModel(customerMapper.customerToCustomerDTO(customer));
        return customerResource;
    }

    public CollectionModel<EntityModel<CustomerDTO>> getAllCustomers() {
        List<EntityModel<CustomerDTO>> customers = customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDTO)
                .map(assembler::toModel)
                .collect(Collectors.toList());
        CollectionModel<EntityModel<CustomerDTO>> customersResource = CollectionModel.of(
                customers,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getAllCustomers()).withSelfRel());
        return customersResource;
    }

    public EntityModel<CustomerDTO> updateCustomer(long id, CustomerDTO customerDTO) {
        Customer updatedCustomer = new Customer();
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
                    customer.setId(id);
                    customer.setVersion(existingCustomer.getVersion());
                    return customerMapper.customerToCustomerDTO(updatedCustomer);
                }).map(assembler::toModel)
                .orElseThrow(()-> new NotFoundException("Customer not found"));
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
