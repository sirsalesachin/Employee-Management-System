package com.project.employee_management.Repository;

import com.project.employee_management.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepo extends MongoRepository<Employee, String> {


    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartment(String department);

}
