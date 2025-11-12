import React, { useState, useEffect } from "react"
import { deleteEmployeeById, getEmployee } from "../service/EmployeeService";
import { useNavigate } from "react-router-dom";

function ListEmployee() {

    const navigate = useNavigate();
    const [employees, setEmployees] = useState([])

    useEffect(() => {
        getEmployee().then((emp) => {
            setEmployees(emp.data);
        });
    }, [])

    const addEmployee = () => {
        navigate("/add-employee");
    }

    const deleteEmployee=(id)=>{
        deleteEmployeeById(id).then(()=>{
            setEmployees((employees)=>employees.filter((employee)=>employee.eid!==id));
        })
        
    }
    return (
        <div className="m-4">

            <h2 className="text-center"> Employee List</h2>
            <div className="row">
                <button className='btn btn-primary' onClick={addEmployee}>ADD
                    EMPLOYEE</button>
            </div><br />
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th> Employee First Name</th>
                            <th> Employee Last Name</th>
                            <th> Employee Email Id</th>
                            <th> Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.eid}>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.emailId}</td>
                                <td>
                                    <button onClick={() =>
                                        navigate(`/update-employee/${employee.eid}`)}
                                        className="btn btn-info">Update</button>

                                    <button onClick={() => deleteEmployee(employee.eid)} className="btn
                                         btn-danger ml-2">Delete</button>
                                </td>
                            </tr>
                        ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default ListEmployee;