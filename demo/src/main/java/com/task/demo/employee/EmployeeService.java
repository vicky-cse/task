package com.task.demo.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	public void saveEmployee(Employee employee) {
		LocalDate date3 = LocalDate.parse("2020-08-09");
		System.out.println(" add ser "+employee.getPassword());
		empRepository.save(employee);
	}
	
	public List<Employee> getEmployee(){
		
		List<Employee> empList = (List<Employee>) empRepository.findAll();
		
		for(Employee empObj : empList){
			Optional<District> distOp =  districtRepository.findById(Integer.valueOf(empObj.getDistrictId()));
			District distr =distOp.get(); 
			String district = distr.getCity();
			empObj.setDistrict(district);
			
			Optional<State> stateOp =  stateRepository.findById(Integer.valueOf(empObj.getStateId()));
			State state =stateOp.get(); 
			String stateStr = state.getCity();
			empObj.setState(stateStr);
		}
		
		return empList;
	}
	
	public Employee getEmployeeById(int id){
		Optional<Employee> empOp =  empRepository.findById(id);
		
		if(empOp.isPresent())
		{
			
			Employee emp = empOp.get();
			Optional<District> distOp =  districtRepository.findById(Integer.valueOf(emp.getDistrictId()));
			District distr =distOp.get(); 
			String district = distr.getCity();
			emp.setDistrict(district);
			
			Optional<State> stateOp =  stateRepository.findById(Integer.valueOf(emp.getStateId()));
			State state =stateOp.get(); 
			String stateStr = state.getCity();
			emp.setState(stateStr);
			
			return emp;
		}
		else 
			return null;
	}
	public void updateEmployee(Employee employee) {
		System.out.println("update "+employee.getName());
		empRepository.save(employee);
	}
	
	public String removeEmployee(int id) {
		Optional<Employee> empOp =  empRepository.findById(id);
		if(empOp.isPresent())
		{
		empRepository.deleteById(id);;
		return "removed";
		}
		else
			return "id is not exist";
	}
	
	
	
}
