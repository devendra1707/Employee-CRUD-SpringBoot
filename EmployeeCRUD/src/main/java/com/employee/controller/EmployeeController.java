package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// 1. save

	@PostMapping(value = "save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Integer id = employeeService.saveEmployee(employee);

		return new ResponseEntity<String>("Employee '" + id + "' saved", HttpStatus.OK);
	}
	// 2. fetch all

	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	// 3.fetch one
	@GetMapping(value = "/one/{empId}")
	public ResponseEntity<Employee> getOneEmployees(@PathVariable("empId") Integer empId) {
		Employee employee = employeeService.getOneEmployee(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	// 4. delete

	@DeleteMapping(value = "remove/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>("Employee '" + empId + "' Deleted.", HttpStatus.OK);
	}

	// 5. update

	@PutMapping(value = "/update/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee) {

		Employee db = employeeService.getOneEmployee(empId);
		db.setEmpName(employee.getEmpName());
		db.setEmpSal(employee.getEmpSal());
		db.setEmpDept(employee.getEmpDept());

		employeeService.saveEmployee(db);

		return new ResponseEntity<String>("Employee '" + empId + "' Updated.", HttpStatus.OK);

	}
}
