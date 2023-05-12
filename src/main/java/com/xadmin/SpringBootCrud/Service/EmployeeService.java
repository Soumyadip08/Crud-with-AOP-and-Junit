package com.xadmin.SpringBootCrud.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.Entity.Employee;
import com.xadmin.SpringBootCrud.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepo;

    public List<Employee> getAllEmployees(){
	List<Employee>employees =new ArrayList<>();
	
	employeeRepo.findAll().forEach(employees::add);
	return employees;
	
}

	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}

	public void updateEmployee(Long id, Employee employee) {
		employeeRepo.save(employee);

		
	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		
	}

	public Employee findById(Long id) {
		return employeeRepo.findById(id).orElseThrow();

	}
}
