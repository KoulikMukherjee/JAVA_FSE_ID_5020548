package com.EmployeeManagement.projections;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    Long getId();

    @Value("#{target.name}")
    String getFullName();

    String getEmail();

    String getDepartmentName();
}
