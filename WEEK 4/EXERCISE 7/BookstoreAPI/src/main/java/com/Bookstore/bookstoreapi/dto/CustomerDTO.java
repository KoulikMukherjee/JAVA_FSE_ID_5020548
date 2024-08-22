package com.Bookstore.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    @JsonProperty("Customer_Id")
    private long id;
    @JsonProperty("First_name")
    private String firstName;
    @JsonProperty("Last_name")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Password")
    private String password;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
