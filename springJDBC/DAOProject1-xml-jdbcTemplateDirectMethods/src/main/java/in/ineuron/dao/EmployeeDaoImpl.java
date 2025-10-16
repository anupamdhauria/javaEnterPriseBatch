package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String SQL_COUNT_QUERY = "select count(*) from employee";
	private static final String SQL_SELECT_QUERY_BY_ID = "select ename from employee where eid=?";
	private static final String SQL_SELECT_QUERY_DETAILS_BY_ID = "select eid,ename,eage,eaddress,desg,salary from employee where eid=?";
	private static final String SQL_QUERY_BY_DESIGNATION = "select eid,ename,eage,eaddress,desg,salary from employee where desg IN (?,?) order by salary";
	private static final String INSERT_QUERY = "insert into employee(`ename`,`eage`,`eaddress`,`desg`,`salary`)values(?,?,?,?,?)";
	private static final String UPDATE_BONUS_QUERY = "update employee set salary=salary+? where desg=?";
	
	//create a referece of jdbcTemplate
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getEmpsCount() {
		return jdbcTemplate.queryForObject(SQL_COUNT_QUERY, Integer.class);
	}

	@Override
	public String getEmployeeNameByID(int empID) {
		
		return jdbcTemplate.queryForObject(SQL_SELECT_QUERY_BY_ID, String.class,empID);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsById(int empid) {
		Map<String,Object>map=jdbcTemplate.queryForMap(SQL_SELECT_QUERY_DETAILS_BY_ID,empid);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2) {
		List<Map<String,Object>>empRecords=jdbcTemplate.queryForList(SQL_QUERY_BY_DESIGNATION,desg1,desg2);
		return empRecords;
	}

	@Override
	public int insertEmployee(String ename, int eage, String eaddress, String desg, int salary) {
		return jdbcTemplate.update(INSERT_QUERY, ename,eage,eaddress,desg,salary);
	}

	@Override
	public int addBonusToEmpByDesg(int bonus, String desg) {
		return jdbcTemplate.update(UPDATE_BONUS_QUERY,bonus,desg);
	}
	

}
