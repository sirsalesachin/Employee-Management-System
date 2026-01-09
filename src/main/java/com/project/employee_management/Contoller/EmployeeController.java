package com.project.employee_management.Contoller;

import com.project.employee_management.Model.Employee;
import com.project.employee_management.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Emp")
public class EmployeeController {

    @Autowired
    private EmployeeService EmpService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee Entry) {
        Employee savedEmployee = EmpService.CreateEmp(Entry);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = EmpService.GetAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String empid) {
        Employee employee = EmpService.GetById(empid);
        return ResponseEntity.ok(employee);
    }


    @PutMapping("/{empid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String empid, @Valid @RequestBody Employee newEntry) {
        Employee updatedEmployee = EmpService.update(empid, newEntry);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empid) {
        EmpService.DeleteById(empid);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
