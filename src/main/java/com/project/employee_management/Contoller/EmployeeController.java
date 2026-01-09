package com.project.employee_management.Contoller;

import com.project.employee_management.Model.Employee;
import com.project.employee_management.Service.EmployeeService;
import com.project.employee_management.dto.EmployeResponseDTO;
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

    @GetMapping
    public List<Employee> getAllEmp(){
        return EmpService.GetAll();
    }

    @PostMapping
    public ResponseEntity<EmployeResponseDTO> createEmployee(
            @Valid @RequestBody EmployeResponseDTO dto) {

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());

        Employee savedEmp = EmpService.CreateEmp(emp);

        // Map entity to response DTO
        EmployeResponseDTO response = new EmployeResponseDTO();
        response.setId(savedEmp.getId());
        response.setName(savedEmp.getName());
        response.setEmail(savedEmp.getEmail());
        response.setDepartment(savedEmp.getDepartment());
        response.setSalary(savedEmp.getSalary());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    public void createEmpEntry(@RequestBody Employee Entry){
//        EmpService.CreateEmp(Entry);
//    }

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
