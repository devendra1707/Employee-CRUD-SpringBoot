package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	Integer saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getOneEmployee(Integer empId);

	void deleteEmployee(Integer empId);

}
