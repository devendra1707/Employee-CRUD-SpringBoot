package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmpoyeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Integer saveEmployee(Employee employee) {
		Integer id = employeeRepository.save(employee).getEmpId();
		return id;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listEmp = employeeRepository.findAll();
		return listEmp;
	}

	@Override
	public Employee getOneEmployee(Integer empId) {
		Optional<Employee> opt = employeeRepository.findById(empId);

		Employee emp = opt.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Exist"));
	
	/*	
		Employee emp = null;
		if(opt.isPresent()) {
			emp =  opt.get();
		}else {
			throw new EmployeeNotFoundException("Employee Not Exist");
		}
		*/
		return emp;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee emp = getOneEmployee(empId);
		employeeRepository.delete(emp);

	}

}
