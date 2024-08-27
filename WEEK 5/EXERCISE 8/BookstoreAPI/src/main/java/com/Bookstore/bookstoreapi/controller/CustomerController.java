package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.BookDTO;
import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.model.Customer;
import com.Bookstore.bookstoreapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/save/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> createCustomerJson(@Valid @RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId() == 0 || customerDTO.getFirstName() == null || customerDTO.getLastName() == null ||
                customerDTO.getEmail() == null || customerDTO.getPassword() == null || customerDTO.getVersion() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        CustomerDTO newCustomer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(newCustomer);
    }

    @PostMapping("/customers/save/form")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> createCustomerForm(
           @Valid @RequestParam int id,
           @Valid @RequestParam String firstName,
           @Valid  @RequestParam String lastName,
           @Valid  @RequestParam String email,
           @Valid  @RequestParam String password,
           @Valid  @RequestParam Integer version) {

        if (id == 0 || firstName == null || lastName == null || email == null || password == null || version == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(firstName);
        customerDTO.setLastName(lastName);
        customerDTO.setEmail(email);
        customerDTO.setPassword(password);
        customerDTO.setId(id);
        customerDTO.setVersion(version);

        CustomerDTO newCustomer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().header("Custom-Success-Header", "Value").body(newCustomer);
    }

    // Get a customer by ID
    @GetMapping("customers/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }

    // Get all customers
    @GetMapping("/customerss/All_Customers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        if(customers.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(customers);
    }

    // Update a customer
    @PutMapping("customers/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    // Delete a customer
    @DeleteMapping("customers/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
