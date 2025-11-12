import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { getEmployeeById, updateEmployee } from '../service/EmployeeService';
function UpdateEmployee() {

    const navigate = useNavigate();
    const {id} = useParams('id');

    const [employee, setEmployee] = useState({
        firstName: '',
        lastName: '',
        emailId: ''
    });

  useEffect(() => {
    const fetchEmployee = async () => {
      try {
        const response = await getEmployeeById(id);
        const employeeData=response.data;
        setEmployee({
          firstName: employeeData.firstName,
          lastName: employeeData.lastName,
          emailId: employeeData.emailId
        });
      } catch (error) {
        console.log(error);
      }
    };

    fetchEmployee();
  }, [id]);

    const UpdateEmployee = (e) => {

        e.preventDefault();
        console.log(JSON.stringify(employee));
        updateEmployee(employee,id).then((res) => {
            navigate("/employees");
        })
    }

    const cancel = (e) => {
        navigate("/employees");
    }


    return (
        <div>
            <br></br>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Add Employee</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> First Name: </label>
                                    <input placeholder="First Name" name="firstName" className="form-control"
                                        value={employee.firstName} onChange={(e) => setEmployee({ ...employee, firstName: e.target.value })} />
                                </div>
                                <div className="form-group">
                                    <label> Last Name: </label>
                                    <input placeholder="Last Name" name="lastName" className="form-control"
                                        value={employee.lastName} onChange={(e) => setEmployee({ ...employee, lastName: e.target.value })} />
                                </div>
                                <div className="form-group">
                                    <label> Email Id: </label>
                                    <input placeholder="Email Address" name="emailId" className="form-control"
                                        value={employee.emailId} onChange={(e) => setEmployee({ ...employee, emailId: e.target.value })} />
                                </div>

                                <button className="btn btn-success" onClick={UpdateEmployee}>Update</button>
                                <button className="btn btn-danger" onClick={cancel} style={{ marginLeft: "10px" }}>Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );

}
export default UpdateEmployee;