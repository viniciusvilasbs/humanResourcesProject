package com.viniciusvb.hr.service;

import com.viniciusvb.hr.dto.EmployeeDto;
import com.viniciusvb.hr.model.Employee;
import com.viniciusvb.hr.model.EmployeeStatus;
import com.viniciusvb.hr.repository.EmployeeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<EmployeeDto> findAll() {
        List<Employee> allEmployeesList = employeeRepository.findAll();
        return allEmployeesList.stream()
                .map(EmployeeDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmployeeDto findById(Long employeeId) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            Employee employee = employeeRepository.findById(employeeId).get();
            return new EmployeeDto(employee);
        } else {
            throw new ObjectNotFoundException("Employee not found, id: ", employeeId);
        }
    }

    @Transactional
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Transactional
    public void delete(Long employeeId) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            employeeRepository.deleteById(employeeId);
            employeeRepository.flush();
        } else {
            throw new ObjectNotFoundException("Employee not found, id: ", employeeId);
        }
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
