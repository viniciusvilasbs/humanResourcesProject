package com.viniciusvb.hr.service;

import com.viniciusvb.hr.dto.EmployeeDto;
import com.viniciusvb.hr.model.Employee;
import com.viniciusvb.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll() {
        List<Employee> allEmployeesList = employeeRepository.findAll();
        return allEmployeesList.stream()
                .map(EmployeeDto::new)
                .toList();
    }

    @Transactional
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }

    public Employee fromDto(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getName(), employeeDto.getEmail(),
                employeeDto.getSalary(), employeeDto.getAdmissionDate(), employeeDto.getStatus());
    }

    public EmployeeDto fromEmployee(Employee employee) {
        return new EmployeeDto(employee.getName(), employee.getEmail(), employee.getSalary(),
                employee.getAdmissionDate(), employee.getStatus());
    }
}
