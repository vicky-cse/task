package com.task.demo.employee;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends  CrudRepository<Employee,Integer> {

}
