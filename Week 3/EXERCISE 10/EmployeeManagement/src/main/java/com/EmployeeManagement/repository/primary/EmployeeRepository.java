package com.EmployeeManagement.repository.primary;

import com.EmployeeManagement.model.Employee;
import com.EmployeeManagement.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, d.name AS departmentName " +
            "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllProjectedEmployees();
}
