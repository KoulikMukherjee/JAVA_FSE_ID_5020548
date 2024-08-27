package com.Bookstore.bookstoreapi.repository;

import com.Bookstore.bookstoreapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional query methods
}
