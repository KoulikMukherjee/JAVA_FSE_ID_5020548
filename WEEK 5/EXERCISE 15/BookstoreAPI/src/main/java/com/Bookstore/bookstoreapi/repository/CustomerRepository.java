package com.Bookstore.bookstoreapi.repository;

import com.Bookstore.bookstoreapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
