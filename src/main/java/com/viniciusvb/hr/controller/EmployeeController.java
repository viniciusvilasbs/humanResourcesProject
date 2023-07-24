package com.viniciusvb.hr.controller;

import com.viniciusvb.hr.dto.EmployeeDto;
import com.viniciusvb.hr.model.Employee;
import com.viniciusvb.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> registration(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.fromDto(employeeDto);
        employeeService.save(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
