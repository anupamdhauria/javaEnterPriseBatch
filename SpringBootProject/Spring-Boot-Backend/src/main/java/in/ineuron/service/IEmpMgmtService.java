package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Employee;

public interface IEmpMgmtService {

	public List<Employee>findAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee findEmployeeById(Integer Id);
	public void deleteEmployeeById(Integer Id);
}
