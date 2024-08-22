package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @PostMapping("/customers/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCustomerJson(@RequestBody Customer customer) {
        if (customer.getId() == 0 || customer.getFirstName() == null || customer.getLastName() == null ||
                customer.getEmail() == null || customer.getPassword() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
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

        Customer customer = new Customer(id, firstName, lastName, email, password);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(customer);
    }
}
