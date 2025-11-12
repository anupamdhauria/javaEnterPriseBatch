package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.Exception.EmployeeNotFoundException;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.model.Employee;

@Service
public class EmpMgmtServiceImpl implements IEmpMgmtService{
	
	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<Employee> findAllEmployees() {
		Iterable<Employee> listEmployees = dao.findAll();
		return (List<Employee>)listEmployees;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee findEmployeeById(Integer Id) {
		Optional<Employee> optional = dao.findById(Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		 throw new EmployeeNotFoundException("employee not found");
	}

	@Override
	public void deleteEmployeeById(Integer Id) {
		Optional<Employee> optional = dao.findById(Id);
		if(optional.isPresent()) {
			dao.deleteById(Id);
		}else {
		 throw new EmployeeNotFoundException("employee not found");
		}
	}

}
