package com.EmployeeManagement.projections;

public class EmployeeDTO {

    private Long id;
    private String fullName;
    private String email;
    private String departmentName;

    public EmployeeDTO(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.fullName = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
