package com.salah.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@BatchSize(size = 25)
@Entity
@Table(name = "Employee")
public class Employee {
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private long employeeId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private int salary;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinColumn(name = "department_id", referencedColumnName = "departmentId")
	private Department department;

}
