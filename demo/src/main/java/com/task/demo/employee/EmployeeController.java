package com.task.demo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/employee")
	private String addEmployee(@RequestBody Employee employee) {
		empService.saveEmployee(employee);
		return "added";
	}
	
	@PutMapping("/employee")
	private String putEmployee(@RequestBody Employee employee) {
		empService.updateEmployee(employee);
		return "updated";
	}
	
	@GetMapping("/employee")
	private List<Employee> getEmployees() {
		 List<Employee> empList = empService.getEmployee();
		return empList;
	}
	
	@GetMapping("/employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		Employee emp = empService.getEmployeeById(id);
		return emp;
	}
	
	@DeleteMapping("/employee/{id}")
	private String deleteEmployee(@PathVariable("id") int id) {
		String res = empService.removeEmployee(id);
		return res;
	}
}
