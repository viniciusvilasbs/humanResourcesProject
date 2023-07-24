package com.viniciusvb.hr.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Objects;

@Entity
@Table(name = "tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private BigDecimal salary;

    private LocalDate admissionDate;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(String name, String email, BigDecimal salary, LocalDate admissionDate, EmployeeStatus status) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", admissionDate=" + admissionDate +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
