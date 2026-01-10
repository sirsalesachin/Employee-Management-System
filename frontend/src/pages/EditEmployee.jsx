import React, { useEffect, useState } from "react";
import { getEmployeeById, updateEmployee } from "../services/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";
import EmployeeForm from "../components/EmployeeForm";

const EditEmployee = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    name: "",
    email: "",
    department: "",
    salary: ""
  });

  useEffect(() => {
    const loadEmployee = async () => {
      const response = await getEmployeeById(id);
      setEmployee(response.data);
    };
    loadEmployee();
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    await updateEmployee(id, employee);
    navigate("/");
  };

  return (
    <div>
      <h2 className="mb-4">Edit Employee</h2>
      <EmployeeForm
        employee={employee}
        setEmployee={setEmployee}
        handleSubmit={handleSubmit}
        buttonText="Update Employee"
      />
    </div>
  );
};

export default EditEmployee;
