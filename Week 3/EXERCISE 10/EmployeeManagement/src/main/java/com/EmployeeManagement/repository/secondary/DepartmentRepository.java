package com.EmployeeManagement.repository.secondary;

import com.EmployeeManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
