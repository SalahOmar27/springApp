package com.salah.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDto> getAllEmployee() {
		return employeeRepository.findAll().stream().map(this::convertEmployeeToDto).collect(Collectors.toList());

	}

	private EmployeeDto convertEmployeeToDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		employeeDto.setPhone(employee.getPhone());
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setDepartmentId(employee.getDepartment().getDepartmentId());
		return employeeDto;
	}
}
