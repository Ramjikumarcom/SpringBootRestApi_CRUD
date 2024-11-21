package com.demo.wipro.controller;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
