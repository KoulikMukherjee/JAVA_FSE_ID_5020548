package com.employeemanagement.repository;

import com.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);

    List<Employee> findByDepartmentName(String departmentName);
}
