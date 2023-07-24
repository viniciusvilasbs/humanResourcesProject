package com.viniciusvb.hr.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salary;
    private LocalDateTime admissionDate;
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(String name, String email, BigDecimal salary, LocalDateTime admissionDate, EmployeeStatus status) {
        super(name, email);
        this.salary = salary;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
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

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
