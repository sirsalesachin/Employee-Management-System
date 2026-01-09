# Employee Management System

## Project Overview
Employee Management System is a backend application developed using **Java, Spring Boot, and MongoDB**.  
It provides a RESTful API for managing employee records with **full CRUD operations** (Create, Read, Update, Delete).

The project implements:
- **Validation** using `@Valid` and field-level annotations
- **Global Exception Handling** using `@RestControllerAdvice`
- **Layered architecture** (Controller → Service → Repository → MongoDB)

---

## Features
- Add new employees
- View all employees
- View employee by ID
- Update employee details
- Delete employee
- Input validation for all fields
- Custom exception handling for resource not found
- Consistent JSON error responses

---

## Technology Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MongoDB
- **Validation:** Hibernate Validator (`@NotBlank`, `@Email`, `@NotNull`)
- **Exception Handling:** `@RestControllerAdvice`, custom exceptions
- **Build Tool:** Maven
- **Version Control:** Git / GitHub

---

## Project Structure
