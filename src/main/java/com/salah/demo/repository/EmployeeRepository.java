package com.salah.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salah.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT first_name,salary FROM Employee ORDER BY salary  LIMIT 10,1", nativeQuery = true)
	Employee getEmployee10thMaxSalary();

	@Query(value = "SELECT department.department_name,COUNT(employee.employee_id) FROM employee JOIN department WHERE employee.employee_id = department.department_id GROUP BY department.department_name;", nativeQuery = true)
	List<Employee> employeePerDepartment();

}
