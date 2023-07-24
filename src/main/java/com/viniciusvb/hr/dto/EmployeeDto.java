package com.viniciusvb.hr.dto;

import com.viniciusvb.hr.model.Employee;
import com.viniciusvb.hr.model.EmployeeStatus;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private BigDecimal salary;
    private LocalDate admissionDate;
    private EmployeeStatus status;

    public EmployeeDto() {
    }

    public EmployeeDto(Employee entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public EmployeeDto(String name, String email, BigDecimal salary, LocalDate admissionDate, EmployeeStatus status) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
