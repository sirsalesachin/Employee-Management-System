const API_URL = "/Emp"; // same server

const form = document.getElementById("empForm");
const table = document.getElementById("empTable");

window.onload = loadEmployees;

// ================= GET ALL =================
function loadEmployees() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            table.innerHTML = "";
            data.forEach(emp => {
                table.innerHTML += `
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.email}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.department}</td>
                        <td>
                            <button onclick="editEmployee('${emp.id}')">Edit</button>
                            <button onclick="deleteEmployee('${emp.id}')">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}

// ================= ADD / UPDATE =================
form.addEventListener("submit", function (e) {
    e.preventDefault();

    const id = document.getElementById("id").value;

    const employee = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        salary: document.getElementById("salary").value,
        department: document.getElementById("department").value
    };

    if (id === "") {
        // CREATE
        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(employee)
        }).then(() => {
            form.reset();
            loadEmployees();
        });
    } else {
        // UPDATE
        fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(employee)
        }).then(() => {
            form.reset();
            document.getElementById("id").value = "";
            loadEmployees();
        });
    }
});

// ================= EDIT =================
function editEmployee(id) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(emp => {
            document.getElementById("id").value = emp.id;
            document.getElementById("name").value = emp.name;
            document.getElementById("email").value = emp.email;
            document.getElementById("salary").value = emp.salary;
            document.getElementById("department").value = emp.department;
        });
}

// ================= DELETE =================
function deleteEmployee(id) {
    if (confirm("Delete employee?")) {
        fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        }).then(() => loadEmployees());
    }
}
