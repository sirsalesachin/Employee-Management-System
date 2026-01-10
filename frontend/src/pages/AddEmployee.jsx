import React, { useState } from "react";
import { addEmployee } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";
import EmployeeForm from "../components/EmployeeForm";

const AddEmployee = () => {
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    name: "",
    email: "",
    department: "",
    salary: ""
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    await addEmployee(employee);
    navigate("/");
  };

  return (
    <div>
      <h2 className="mb-4">Add Employee</h2>
      <EmployeeForm
        employee={employee}
        setEmployee={setEmployee}
        handleSubmit={handleSubmit}
        buttonText="Add Employee"
      />
    </div>
  );
};

export default AddEmployee;
