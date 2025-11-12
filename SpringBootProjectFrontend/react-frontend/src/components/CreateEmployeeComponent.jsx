import React, { useState } from 'react'
import {  useNavigate } from 'react-router-dom';
import { createEmployee } from '../service/EmployeeService';
function CreateEmployeeComponent(){

    const navigate=useNavigate();
    const [employee,setEmployee]=useState({
        firstName:'',
        lastName:'',
        emailId:''
    });

    const saveOrUpdateEmployee=(e)=>{

        e.preventDefault();
        console.log(JSON.stringify(employee));
        createEmployee(employee).then((res)=>{
            navigate("/");
        })
    }

    const cancel=(e)=>{
       navigate("/");
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
                    value={employee.firstName} onChange={(e)=>setEmployee({...employee,firstName:e.target.value})} />
                </div>
                <div className="form-group">
                  <label> Last Name: </label>
                  <input placeholder="Last Name" name="lastName" className="form-control"
                    value={employee.lastName} onChange={(e)=>setEmployee({...employee,lastName:e.target.value})} />
                </div>
                <div className="form-group">
                  <label> Email Id: </label>
                  <input placeholder="Email Address" name="emailId" className="form-control"
                    value={employee.emailId} onChange={(e)=>setEmployee({...employee,emailId:e.target.value})}/>
                </div>

                <button className="btn btn-success" onClick={saveOrUpdateEmployee}>Save</button>
                <button className="btn btn-danger" onClick={cancel} style={{ marginLeft: "10px" }}>Cancel</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );

}
export default CreateEmployeeComponent;