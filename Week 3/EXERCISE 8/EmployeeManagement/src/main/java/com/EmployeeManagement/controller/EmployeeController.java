package com.EmployeeManagement.controller;

import com.EmployeeManagement.projections.EmployeeProjection;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projection")
    public List<EmployeeProjection> getEmployeesProjection() {
        return employeeRepository.findAllProjectedEmployees();
    }
}
