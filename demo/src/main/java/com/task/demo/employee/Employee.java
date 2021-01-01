package com.task.demo.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;

@Entity 
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	@Column(name="state_id")
	private String stateId;
	
	@Column(name="district_id")
	private String districtId;
	
	private String district;
	private String state;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = LocalDate.parse(dob);
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
