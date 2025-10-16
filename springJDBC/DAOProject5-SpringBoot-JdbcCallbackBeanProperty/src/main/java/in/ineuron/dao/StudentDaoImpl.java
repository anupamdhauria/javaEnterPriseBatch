package in.ineuron.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao {
	
	private static final String SELECT_BY_ID = "SELECT sid,sname,sage,saddress from STUDENT where sid=?";
	private static final String SELECT_BY_NAME = "SELECT sid,sname,sage,saddress from STUDENT where sname IN (?,?)";
	private static final String GET_STUDENT_BY_CITY = "SELECT sid,sname,sage,saddress from STUDENT where saddress IN (?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentBO getStudentById(int sid) {
		
		StudentBO stdbo=null;
		stdbo=jdbcTemplate.queryForObject(SELECT_BY_ID,new BeanPropertyRowMapper<StudentBO>(StudentBO.class)
			, sid);
		return stdbo;
	}


	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		List<StudentBO> stdbo=null;
		stdbo=jdbcTemplate.query(SELECT_BY_NAME, (rs,rowNo)->{
			System.out.println("StudentDaoImpl.getStudentByName().rowmapper");
			StudentBO bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		},name1,name2);
		return stdbo;
	}


	@Override
	public List<StudentBO> getStudentByCity(String city1, String city2, String city3) {
		
		//ResultSetExtactor(I)
		
		/*
		 * return jdbcTemplate.query(GET_STUDENT_BY_CITY, new
		 * ResultSetExtractor<List<StudentBO>>(){
		 * 
		 * @Override public List<StudentBO> extractData(ResultSet rs) throws
		 * SQLException, DataAccessException { List<StudentBO>bo=null; bo=new
		 * ArrayList<>(); System.out.
		 * println("StudentDaoImpl.getStudentByCity(...).new ResultSetExtractor() {...}.extractData()"
		 * ); while(rs.next()) { StudentBO stdbo = new StudentBO();
		 * stdbo.setSid(rs.getInt(1)); stdbo.setSname(rs.getString(2));
		 * stdbo.setSage(rs.getInt(3)); stdbo.setSaddress(rs.getString(4));
		 * bo.add(stdbo); }
		 * 
		 * return bo; }
		 * 
		 * 
		 * },city1,city2,city3);
		 */
//		
		//RowMapperResultSetExtractor(C)  
		
//		return jdbcTemplate.query(GET_STUDENT_BY_CITY, new RowMapperResultSetExtractor<StudentBO>(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)),city1,city2,city3);
		
		
		//RowCallbackhandler
		
		
		List<StudentBO>stdBo=new ArrayList<>();
		
		jdbcTemplate.query(GET_STUDENT_BY_CITY, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				System.out.println("StudentDaoImpl.getStudentByCity(...).new RowCallbackHandler() {...}.processRow()");
				StudentBO bo = new StudentBO();
				bo.setSid(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSage(rs.getInt(3));
				bo.setSaddress(rs.getString(4));
				stdBo.add(bo);
				
			}
			
		},city1,city2,city3);
		return stdBo;
		
	}
	
	
}
