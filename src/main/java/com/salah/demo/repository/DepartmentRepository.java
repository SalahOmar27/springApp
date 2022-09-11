package com.salah.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salah.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
