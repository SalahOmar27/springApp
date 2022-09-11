package com.salah.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salah.demo.dao.EmployeeDao;
import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;
import com.salah.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<EmployeeDto> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody EmployeeDao employeeDao) {
		return employeeRepository.save(employeeDao.getEmployee());

	}

	@GetMapping("/getEmployee10thMaxSalary")
	public Employee getEmployee10thMaxSalary() {
		return employeeRepository.getEmployee10thMaxSalary();

	}

	@GetMapping("/employeePerDepartment")
	public List<Employee> employeePerDepartment() {
		return employeeRepository.employeePerDepartment();
	}

}
