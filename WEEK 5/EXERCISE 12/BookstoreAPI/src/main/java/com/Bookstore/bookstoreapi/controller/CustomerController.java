package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.dto.CustomerDTO;
import com.Bookstore.bookstoreapi.metrics.CustomerCustomMetrics;
import com.Bookstore.bookstoreapi.assembler.CustomerResourceAssembler;
import com.Bookstore.bookstoreapi.service.CustomerService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerResourceAssembler customerResourceAssembler;
    private final CustomerCustomMetrics metrics;

    public CustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler, CustomerCustomMetrics metrics) {
        this.customerService = customerService;
        this.customerResourceAssembler = customerResourceAssembler;
        this.metrics = metrics;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        EntityModel<CustomerDTO> customerResource = customerResourceAssembler.toModel(customerDTO);
        return ResponseEntity.ok(customerResource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        EntityModel<CustomerDTO> customerResource = customerResourceAssembler.toModel(createdCustomer);
        metrics.incrementCustomerCreated();
        return ResponseEntity.created(customerResource.getRequiredLink("self").toUri()).body(customerResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<CustomerDTO>> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        EntityModel<CustomerDTO> customerResource = customerResourceAssembler.toModel(updatedCustomer);
        return ResponseEntity.ok(customerResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        metrics.incrementCustomerDeleted();
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<CustomerDTO>>> getAllCustomers() {
        List<EntityModel<CustomerDTO>> customerResources = customerService.getAllCustomers().stream()
                .map(customerResourceAssembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerResources);
    }
}
