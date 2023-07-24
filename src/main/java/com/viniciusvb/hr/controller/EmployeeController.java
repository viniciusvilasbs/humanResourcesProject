package com.viniciusvb.hr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping
    public String teste() {
        return "Teste 123";
    }

}
