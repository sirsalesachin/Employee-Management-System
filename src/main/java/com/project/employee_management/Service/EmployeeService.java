package com.project.employee_management.Service;

import com.project.employee_management.Model.Employee;
import com.project.employee_management.Repository.EmployeeRepo;
import com.project.employee_management.exception.EmployeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo EmpRepo;

    public List<Employee> GetAll(){
        return EmpRepo.findAll();
    }

    public void CreateEmp(@RequestBody Employee Entry){
        EmpRepo.save(Entry);
    }

    public Employee GetById(@PathVariable String Empid){
        return EmpRepo.findById(Empid).orElseThrow(() -> new EmployeNotFoundException("Employee not found with id: " + Empid));
    }

    public Employee updateEmployee(Employee newEntry) {
        return EmpRepo.save(newEntry);
    }

    public void DeleteById(@PathVariable String Empid){
        EmpRepo.deleteById(Empid);
    }
}
