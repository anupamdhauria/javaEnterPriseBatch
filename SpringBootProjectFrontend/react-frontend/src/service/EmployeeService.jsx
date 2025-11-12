

import axios from 'axios'

const EMP_BASE_URL = "http://localhost:9999/api/v1/employees";
export const getEmployee = () => {
    return axios.get(EMP_BASE_URL);
}
export const createEmployee = (employee) => {
    return axios.post(EMP_BASE_URL,employee);
}
export function getEmployeeById(employeeId) {
  return axios.get(`${EMP_BASE_URL}/${employeeId}`);
}

export function updateEmployee(employee, employeeId) {
  return axios.put(`${EMP_BASE_URL}/${employeeId}`, employee);
}

export function deleteEmployeeById(employeeId) {
  return axios.delete(`${EMP_BASE_URL}/${employeeId}`);
}