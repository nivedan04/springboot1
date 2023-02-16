package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public  Company saveEmployee(@RequestBody Company company) {
		return service.saveEmployee(company);
	}
	
	@GetMapping("/fetchAll")
	public List<Employee> fetchAllEmps(){
		return service.getAllEmps();
	}
}
