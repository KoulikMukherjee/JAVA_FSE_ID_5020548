package com.EmployeeManagement.model;

import lombok.Setter;
import org.hibernate.annotations.Formula;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @ManyToOne
    private Department department;
    @Formula("(select count(*) from employee e where e.department_id = department_id)")
    private Integer departmentEmployeeCount;

}
