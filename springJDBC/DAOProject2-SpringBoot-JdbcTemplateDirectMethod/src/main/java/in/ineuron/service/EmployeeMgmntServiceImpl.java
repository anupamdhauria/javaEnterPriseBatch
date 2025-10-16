package in.ineuron.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IEmployeeDAO;

@Service
public class EmployeeMgmntServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeDAO employeeDao;
	

	
	@Override
	public int fetchEmpsCount() {
		return employeeDao.getEmpsCount();
		
	}

	@Override
	public String getEmployeeNameById(int empID) {
		return employeeDao.getEmployeeNameByID(empID);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsById(int empid) {
		return employeeDao.getEmployeeDetailsById(empid);
	}

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2) {
		return employeeDao.getEmployeeDetailsByDesignation(desg1, desg2);
	}

	@Override
	public int insertEmployee(String ename, int eage, String eaddress, String desg, int salary) {
		return employeeDao.insertEmployee(ename, eage, eaddress, desg, salary);
	}

	@Override
	public int addBonusToEmpByDesg(int bonus, String desg) {	
		return employeeDao.addBonusToEmpByDesg(bonus, desg);
	}

}
