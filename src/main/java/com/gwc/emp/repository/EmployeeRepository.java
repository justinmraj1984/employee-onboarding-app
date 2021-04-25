package com.gwc.emp.repository;

import org.springframework.data.repository.CrudRepository;
import com.gwc.emp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
