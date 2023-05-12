package com.xadmin.SpringBootCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.Entity.Employee;
import com.xadmin.SpringBootCrud.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	// http://localhost:9191/employees/

	@GetMapping("/employees")								// to get all the employees
	public List<Employee>getAllEmployees(){

		return employeeService.getAllEmployees();
	}

	public Employee findById(@PathVariable(value = "id") Long id){
		return employeeService.findById(id);

	}
	
	
	// @RequestMapping(method=RequestMethod.POST, value="/employees")    //we use this instead of @PostMapping
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")				   // If we update an employee using id
	public void updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
	}
	
	
	public void deleteEmployee(@PathVariable Long id) {					// as we know its delete an employee following by id
		employeeService.deleteEmployee(id);
		
	}
	
	
}
