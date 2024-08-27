package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customers/save/json",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomerJson(@Valid @RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId() == 0 || customerDTO.getFirstName() == null || customerDTO.getLastName() == null ||
                customerDTO.getEmail() == null || customerDTO.getPassword() == null || customerDTO.getVersion() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        EntityModel<CustomerDTO> newCustomer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().header("Succesfully Registered", "Value").body(newCustomer);
    }

    @PostMapping(value = "/customers/save/form",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomerForm(
           @Valid @RequestParam int id,
           @Valid @RequestParam String firstName,
           @Valid  @RequestParam String lastName,
           @Valid  @RequestParam String email,
           @Valid  @RequestParam String password,
           @Valid  @RequestParam Integer version) {

        if (id == 0 || firstName == null || lastName == null || email == null || password == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(firstName);
        customerDTO.setLastName(lastName);
        customerDTO.setEmail(email);
        customerDTO.setPassword(password);
        customerDTO.setId(id);
        customerDTO.setVersion(version);

        EntityModel<CustomerDTO> newCustomer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().header("Succesfully Registered", "Value").body(newCustomer);
    }

    // Get a customer by ID
    @GetMapping(value = "customers/find/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable Long id) {
        EntityModel<CustomerDTO> customerResource = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerResource);
    }

    // Get all customers
    @GetMapping(value = "/customerss/All_Customers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CollectionModel<EntityModel<CustomerDTO>>> getAllCustomers() {
        CollectionModel<EntityModel<CustomerDTO>> customers = customerService.getAllCustomers();
        if(customers.getContent().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(customers);
    }

    // Update a customer
    @PutMapping(value = "customers/update/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EntityModel<CustomerDTO>> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDTO customerDTO) {
        EntityModel<CustomerDTO> customerResource = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(customerResource);
    }

    // Delete a customer
    @DeleteMapping("customers/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
