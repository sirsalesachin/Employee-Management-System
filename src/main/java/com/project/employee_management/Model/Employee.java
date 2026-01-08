package com.project.employee_management.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EmpData")
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String department;
    private double salary;
}
