package com.xadmin.SpringBootCrud.Repository;

import org.springframework.data.repository.CrudRepository;

import com.xadmin.SpringBootCrud.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
