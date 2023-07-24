package com.viniciusvb.hr.controller;

import com.viniciusvb.hr.dto.EmployeeDto;
import com.viniciusvb.hr.model.Employee;
import com.viniciusvb.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path = "/{employeeId}")
    public EmployeeDto findById(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee registration(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.fromDto(employeeDto);
        return employeeService.save(employee);
    }

    @DeleteMapping(path = "/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long employeeId) {
        employeeService.delete(employeeId);
    }
}
