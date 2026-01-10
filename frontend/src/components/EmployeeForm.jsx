import React from "react";

const EmployeeForm = ({ employee, setEmployee, handleSubmit, buttonText }) => {
  const handleChange = (e) => setEmployee({ ...employee, [e.target.name]: e.target.value });

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="name" value={employee.name} onChange={handleChange} placeholder="Name" className="form-control mb-2" required />
      <input type="email" name="email" value={employee.email} onChange={handleChange} placeholder="Email" className="form-control mb-2" required />
      <input type="text" name="department" value={employee.department} onChange={handleChange} placeholder="Department" className="form-control mb-2" required />
      <input type="number" name="salary" value={employee.salary} onChange={handleChange} placeholder="Salary" className="form-control mb-2" required />
      <button type="submit" className="btn btn-success">{buttonText}</button>
    </form>
  );
};

export default EmployeeForm;



