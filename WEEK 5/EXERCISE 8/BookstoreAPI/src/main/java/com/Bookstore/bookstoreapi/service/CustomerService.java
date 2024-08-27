package com.Bookstore.bookstoreapi.service;

import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.exception.NotFoundException;
import com.Bookstore.bookstoreapi.mapper.CustomerMapper;
import com.Bookstore.bookstoreapi.model.Book;
import com.Bookstore.bookstoreapi.model.Customer;
import com.Bookstore.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.customerToCustomerDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(long id, CustomerDTO customerDTO) {
        Customer updatedCustomer = new Customer();
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
                    customer.setId(id);
                    customer.setVersion(existingCustomer.getVersion());
                    return customerMapper.customerToCustomerDTO(updatedCustomer);
                })
                .orElseThrow(()-> new NotFoundException("Customer not found"));
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
