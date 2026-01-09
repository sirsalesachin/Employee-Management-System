package com.project.employee_management.Service;

import com.project.employee_management.exception.EmployeeNotFoundException;
import com.project.employee_management.Model.Employee;
import com.project.employee_management.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    public List<Employee> GetAll() {
        return empRepo.findAll();
    }

    public Employee CreateEmp(Employee entry) {
        return empRepo.save(entry);
    }

    public Employee GetById(String empid) {
        return empRepo.findById(empid).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + empid));
    }

    public Employee update(String empid, Employee newEntry) {

        Employee existing = GetById(empid);
        existing.setName(newEntry.getName());
        existing.setEmail(newEntry.getEmail());
        existing.setDepartment(newEntry.getDepartment());
        existing.setSalary(newEntry.getSalary());

        return empRepo.save(existing);
    }

    public void DeleteById(String empid) {
        Employee existing = GetById(empid);
        empRepo.delete(existing);
    }
}
