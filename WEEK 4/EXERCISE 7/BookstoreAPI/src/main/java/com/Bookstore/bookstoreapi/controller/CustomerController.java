package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.model.Customer;
import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> createCustomerJson(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId() == 0 || customerDTO.getFirstName() == null || customerDTO.getLastName() == null ||
                customerDTO.getEmail() == null || customerDTO.getPassword() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(customer);
    }

    @PostMapping("/customers/form")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCustomerForm(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password) {

        if (id == 0 || firstName == null || lastName == null || email == null || password == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setId(id);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(customer);
    }
}
