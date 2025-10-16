package in.ineuron.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {

	public int getEmpsCount();
	public String getEmployeeNameByID(int empID);
	public Map<String,Object> getEmployeeDetailsById(int empid);
	public List<Map<String,Object>>getEmployeeDetailsByDesignation(String desg1,String desg2);
	public int insertEmployee(String ename,int eage,String eaddress,String desg,int salary);
	public int addBonusToEmpByDesg(int bonus,String desg);
}
