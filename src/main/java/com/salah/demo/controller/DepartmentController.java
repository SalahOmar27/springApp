package com.salah.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salah.demo.dao.DepartmentDao;
import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;
import com.salah.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepartment")
	public List<DepartmentDto> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	@Autowired
	private DepartmentRepository departmentRepository;

	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody DepartmentDao departmentDao) {
		return departmentRepository.save(departmentDao.getDepartment());

	}

	// @EntityGraph(type = EntityGraphType.FETCH,value = "edepartment_entity_graph")

	/*
	 * @GetMapping("/getAllDepartment") public List<Department> getAllDepartment() {
	 * return departmentRepository.findAll(); }
	 */

}
