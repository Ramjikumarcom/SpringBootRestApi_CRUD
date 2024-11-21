package com.demo.wipro.model;

import jakarta.persistence.*;

@Entity // to create database
@Table (name = "emp") // to create table name
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
@Column(name = "first_Name")
    private  String firstName;
@Column(name = "last_Name")
    private  String lastName;
@Column(name = "email_Id")
    private  String email;

    public Employee(long id, String firstName, String email, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }
    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

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



}
