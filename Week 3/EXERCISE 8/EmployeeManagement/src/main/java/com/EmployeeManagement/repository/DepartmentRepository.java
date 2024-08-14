package com.EmployeeManagement.repository;

import com.EmployeeManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Derived query method to find departments by name
    Department findByName(String name);
}
