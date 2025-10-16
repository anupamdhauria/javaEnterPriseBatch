package in.ineuron.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao {
	
	private static final String SELECT_BY_ID = "SELECT sid,sname,sage,saddress from STUDENT where sid=?";
	private static final String SELECT_BY_NAME = "SELECT sid,sname,sage,saddress from STUDENT where sname IN (?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentBO getStudentById(int sid) {
		
		StudentBO stdbo=null;
		stdbo=jdbcTemplate.queryForObject(SELECT_BY_ID,(rs,rowNO)->{
			StudentBO bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		}, sid);
		return stdbo;
	}


	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		List<StudentBO> stdbo=null;
		stdbo=jdbcTemplate.query(SELECT_BY_NAME, (rs,rowNo)->{
			StudentBO bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		},name1,name2);
		return stdbo;
	}
	
	
}
