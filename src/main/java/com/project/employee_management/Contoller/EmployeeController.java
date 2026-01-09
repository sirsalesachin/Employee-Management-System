package com.project.employee_management.Contoller;

import com.project.employee_management.Model.Employee;
import com.project.employee_management.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Emp")
public class EmployeeController {

    @Autowired
    private EmployeeService EmpService;

    @GetMapping
    public List<Employee> getAllEmp(){
        return EmpService.GetAll();
    }

    @PostMapping
    public void createEmpEntry(@RequestBody Employee Entry){
        EmpService.CreateEmp(Entry);
    }

    @GetMapping("/{empid}")
    public Employee getbyid(@PathVariable String empid){
        return EmpService.GetById(empid);
    }

    @PutMapping("/{empid}")
    public Employee updateEmployee(@PathVariable String empid, @RequestBody Employee newEntry) {
        newEntry.setId(empid);
        return EmpService.updateEmployee(newEntry);
    }

    @DeleteMapping("/{empid}")
    public Boolean Deletebyid(@PathVariable String empid){
        EmpService.DeleteById(empid);
        return true;
    }
}
