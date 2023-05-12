package com.xadmin.SpringBootCrud;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.xadmin.SpringBootCrud.Entity.Employee;
import com.xadmin.SpringBootCrud.Repository.EmployeeRepository;
import com.xadmin.SpringBootCrud.Service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCrudApplicationTests {
	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(5L ,"Ram Das" , "HR")).collect(Collectors.toList()));
		assertEquals(1 , employeeService.getAllEmployees().size());
	}

	@Test
	public void addEmployeeTest() {
		Employee employee=new Employee(2L,"Soumyadip Mallick" , "Java Web");
		when(employeeRepository.save(employee)).thenReturn(employee);
	}

	@Test
	public void deleteEmployee() {
		Employee employee=new Employee(2L,"Soumyadip Mallick" , "Java Web");
		employeeService.deleteEmployee(employee.getId());
		verify(employeeRepository , times(1)).deleteById(employee.getId());

	}

}
