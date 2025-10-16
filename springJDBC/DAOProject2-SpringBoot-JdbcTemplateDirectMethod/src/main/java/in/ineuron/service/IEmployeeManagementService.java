package in.ineuron.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeManagementService {

	public int fetchEmpsCount();
	public String getEmployeeNameById(int empID);
	public Map<String,Object>getEmployeeDetailsById(int empid);
	public List<Map<String,Object>>getEmployeeDetailsByDesignation(String desg1,String desg2);
	public int insertEmployee(String ename,int eage,String eaddress,String desg,int salary);
	public int addBonusToEmpByDesg(int bonus,String desg);
}
