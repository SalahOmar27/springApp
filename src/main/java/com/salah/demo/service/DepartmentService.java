package com.salah.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<DepartmentDto> getAllDepartment() {
		return departmentRepository.findAll().stream().map(this::convertDepartmentToDto).collect(Collectors.toList());

	}

	private DepartmentDto convertDepartmentToDto(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentId(department.getDepartmentId());
		departmentDto.setDepartmentName(department.getDepartmentName());
		return departmentDto;
	}

}
